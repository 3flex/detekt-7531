import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.extensions.DetektExtension

buildscript {
    repositories {
        maven(url="https://oss.sonatype.org/content/repositories/snapshots/")
    }
    dependencies {
        classpath("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:main-SNAPSHOT")
    }
}

plugins {
    val ktVersion= "2.0.20-RC"
    kotlin("multiplatform") version ktVersion
    kotlin("plugin.serialization") version ktVersion
}
plugins.apply("io.gitlab.arturbosch.detekt")

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
dependencies {
    commonMainImplementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.1")
}

extensions.configure(DetektExtension::class.java) {
    debug = true
}