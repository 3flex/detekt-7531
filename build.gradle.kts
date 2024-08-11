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
    kotlin("multiplatform") version "2.0.20-RC"
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