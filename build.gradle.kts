import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.extensions.DetektExtension

plugins {
    kotlin("multiplatform") version "2.0.20-RC"
    kotlin("plugin.serialization") version "2.0.20-RC"
    id("io.gitlab.arturbosch.detekt") version "main-SNAPSHOT"
}

detekt {
    debug = true
}

dependencies {
    commonMainImplementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.1")
}

repositories {
    mavenCentral()
    maven(url="https://oss.sonatype.org/content/repositories/snapshots/")
}

kotlin {
    jvm{
        @Suppress("OPT_IN_USAGE")
        mainRun {
            mainClass = "bug.BugKt"
        }
    }
}

tasks.register("allDetekt") {
    dependsOn(tasks.withType<Detekt>())
}
