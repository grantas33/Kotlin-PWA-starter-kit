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
