<p align="center">
  <img src="https://img.shields.io/badge/version-1.0.1-blue.svg" alt="version"> 
  <img src="https://img.shields.io/badge/license-Proprietary-red.svg" alt="license"> 
  <img src="https://img.shields.io/badge/language-Kotlin-7F52FF.svg" alt="kotlin"> 
  <img src="https://img.shields.io/badge/build-Gradle-02303A.svg" alt="gradle"> 
  <img src="https://img.shields.io/badge/platform-JVM-FF6F00.svg" alt="jvm"> 
</p>

<p align="center">
  <pre>
    ██╗  ██╗ ███████╗ ██████╗ █████╗ ███╗   ██╗███╗   ██╗███████╗██████╗ 
    ██║ ██╔╝ ██╔════╝██╔════╝██╔══██╗████╗  ██║████╗  ██║██╔════╝██╔══██╗
    █████╔╝  ███████╗██║     ███████║██╔██╗ ██║██╔██╗ ██║█████╗  ██████╔╝
    ██╔═██╗  ╚════██║██║     ██╔══██║██║╚██╗██║██║╚██╗██║██╔══╝  ██╔══██╗
    ██║  ██╗ ███████║╚██████╗██║  ██║██║ ╚████║██║ ╚████║███████╗██║  ██║
    ╚═╝  ╚═╝ ╚══════╝ ╚═════╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝  
  </pre>
</p>

<h1 align="center">K-Scanner</h1>
<p align="center">
  K-Scanner is a lightweight, fast, and developer-friendly CLI tool written in Kotlin.  
It recursively scans a folder for `TODO` and `FIXME` comments across supported source files and outputs a clean, readable report. Perfect for keeping your codebase tidy, preparing for releases, or enforcing team standards.
</p>

---

## ✨ Features

- 🔍 Recursively scans folders for `TODO` and `FIXME`
- 📄 Supports Markdown or plain text output
- 🎨 Colored terminal output for readability
- 🧭 Relative file paths for clean reports
- 🧹 Ignores non-code files using extension filtering
- 📁 Option to print results or write a report file
- ⚡ Fast, zero-dependency scanning engine

---

## 🚀 Installation

Clone the repository:

```bash
git clone https://github.com/<your-username>/K-Scanner.git
cd K-Scanner
```
Build the project:
```
./gradlew build
```
Run the CLI:

```
./gradlew run --args="<arguments>"
```
## 🛠 Usage
Basic scan (print to terminal)
```
./gradlew run --args="src"
```
Explicit print mode
```
./gradlew run --args="src --output print"
```
Write a Markdown report
```
./gradlew run --args="src --output file --format md"
```
Write a plain text report
```
./gradlew run --args="src --output file --format txt"
```
## 📦 Output Examples
Terminal Output
```
Found 3 TODO items:
src/main/kotlin/App.kt:42 -> // TODO: refactor this
src/utils/Parser.kt:10 -> // FIXME: handle null case
src/utils/Parser.kt:55 -> // TODO: cleanup
Summary: 3 items across 2 file(s).
```
Markdown Report (todo_report.md)
```
# TODO Report

- `src/main/kotlin/App.kt:42` -> // TODO: refactor this
- `src/utils/Parser.kt:10` -> // FIXME: handle null case
- `src/utils/Parser.kt:55` -> // TODO: cleanup
```
## ⚙ Options
| Option           	| Description    	| Values          	| Default  	|
|------------------	|----------------	|-----------------	|----------	|
| ``               	| Folder to scan 	| any folder      	| required 	|
| `-o`, `--output` 	| Output mode    	| `print`, `file` 	| `print`  	|
| `-f`, `--format` 	| File format    	| `md`, `txt`     	| `md`     	|

## 🧩 Supported File Extensions
By default, K-Scanner scans:
```
.kt, .java, .cpp, .c, .h, .rs
```
More extensions will be added in future versions.

## 🗺 Roadmap
* Custom output filename (--name)

* Custom extension list (--extensions)

* JSON output

* Parallel scanning for large repos

* Pre-commit hook integration

* Packaged standalone executable

## 🔒 License (Proprietary)
This project is not open-source.

You may not:

* Copy or redistribute the code

* Modify or create derivative works

* Use the code commercially

* Repackage or sell the software

You may:

* Clone the repository for personal use

* Run the tool as-is

* Inspect the source code

All rights reserved © Kazuya_2006 2025

## 🤝 Contributing

This project does not accept external contributions.

## ⭐ Acknowledgements

Built with ❤️ in Kotlin using the Clikt command-line framework.