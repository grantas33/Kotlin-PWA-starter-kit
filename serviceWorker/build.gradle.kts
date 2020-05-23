import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackOutput.Target

kotlin {
    target {
        browser {
            webpackTask {
                output.libraryTarget = Target.SELF
            }
        }
    }
}

tasks.register<Copy>("copyDevelopmentWebpackToClient") {
    dependsOn("browserDevelopmentWebpack")

    group = "build"
    description = "Copies unprocessed .js output to client's development build directory."

    from("$buildDir/distributions")
    into("${project(":client").buildDir}/processedResources/Js/main")
}
