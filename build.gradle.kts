plugins {
    id("org.jetbrains.kotlin.js") version "1.3.72"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.js")
    }

    repositories {
        mavenCentral()
    }

    val implementation by configurations

    dependencies {
        implementation(kotlin("stdlib-js"))
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:1.3.5")
    }

    tasks.register<Copy>("copyDistribution") {
        group = "build"
        description = "Copies the distribution to the root project distribution."

        from("$buildDir/distributions")
        into("${parent?.buildDir}/distributions")
    }

    tasks["build"].finalizedBy("copyDistribution")
}
