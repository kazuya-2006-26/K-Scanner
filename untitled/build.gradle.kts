plugins {
    kotlin("jvm") version "2.2.10"
}

group = "org.example"
version = "1.0.1"

repositories {
    mavenCentral()
}

dependencies {
    // Clikt – command‑line interface library
    implementation("com.github.ajalt.clikt:clikt:4.2.0")

    // Mordant – beautiful terminal styling
    implementation("com.github.ajalt.mordant:mordant:2.2.0")
}


tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}