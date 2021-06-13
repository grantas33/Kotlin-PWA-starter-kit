repositories {
    maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
    maven("https://jitpack.io")
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin-wrappers:kotlin-styled:5.3.0-pre.204-kotlin-1.5.0")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:17.0.2-pre.204-kotlin-1.5.0")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:17.0.2-pre.204-kotlin-1.5.0")
    implementation("com.github.grantas33:kotlin-pwa-components:v0.1.0")
    implementation(npm("react-loader-spinner", "3.1.14"))
}

kotlin {
    js {
        browser {
            binaries.executable()
        }
    }
}

tasks["browserDevelopmentRun"].dependsOn(":serviceWorker:copyDevelopmentWebpackToClient")