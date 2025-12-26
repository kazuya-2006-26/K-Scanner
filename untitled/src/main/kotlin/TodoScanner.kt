package org.example

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.choice
import java.io.File
import java.lang.Exception
import kotlin.io.path.relativeTo

private const val RED = "\u001B[31m"
private const val GREEN = "\u001B[32m"
private const val YELLOW = "\u001B[33m"
private const val CYAN = "\u001B[36m"
private const val RESET = "\u001B[0m"

data class TodoItem(
    val relPath: String,
    val lineNumber: Int,
    val lineContent: String
)

class TodoScanner : CliktCommand() {
    private val allowedExtensions = listOf(
        "kt", "java", "cpp", "c", "h", "rs",
    )

    private val path by argument(help = "Folder to scan")
    private val output by option("-o", "--output", help = "Output mode")
        .choice("print", "file")
        .default("print")
    private val format by option("-f", "--format", help = "File format")
        .choice("txt", "md")
        .default("md")

    override fun run() {
        val folder = File(path)
        val todos = scanForTodos(folder)

        when (output) {
            "print" -> printReport(todos)
            "file" -> writeReport(todos, format)
        }
    }

    private fun scanForTodos(folder: File): List<TodoItem> {
        val results = mutableListOf<TodoItem>()

        folder.walkTopDown().forEach { file ->
            if (file.isFile && file.extension.lowercase() in allowedExtensions) {
                file.readLines().forEachIndexed { index, line ->
                    if (Regex("\\b(TODO|FIXME)\\b").containsMatchIn(line)) {
                        val relPath = try {
                            file.toPath().relativeTo(folder.toPath()).toString()
                        } catch (e: Exception) {
                            file.path
                        }

                        results.add(TodoItem(relPath, index + 1, line.trim()))
                    }
                }
            }
        }

        return results
    }

    private fun printReport(todos: List<TodoItem>) {
        if (todos.isEmpty()) {
            println("No TODO/FIXME comments found.")
            return
        } else {
            println("${GREEN}Found ${todos.size} TODO items:${RESET}")
            todos.forEach { println("${CYAN}${it.relPath}:${it.lineNumber} -> ${it.lineContent}${RESET}") }
            println("${GREEN}Summary:${RESET} ${todos.size} items across ${getUniqueCount(todos)} file(s).")
        }
    }

    private fun writeReport(todos: List<TodoItem>, format: String) {
        if (todos.isEmpty()) {
            println("No TODO/FIXME comments found.")
            return
        }

        val filename = if (format == "md") "todo_report.md" else "todo_report.txt"

        val content = if (format == "md") {
            buildString {
                append("# TODO Report\n\n")
                todos.forEach { append("- `${it.relPath}:${it.lineNumber}` -> ${it.lineContent}\n") }
            }
        } else {
            todos.joinToString("\n") { "${it.relPath}:${it.lineNumber} -> ${it.lineContent}" }
        }

        File(filename).writeText(content)
        println("Report written to $filename")
    }

    private fun getUniqueCount(todos: List<TodoItem>): Int {
        return todos.map { it.relPath }.toSet().size
    }
}