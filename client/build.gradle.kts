repositories {
    maven("https://jitpack.io")
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin-wrappers:kotlin-styled:5.3.3-pre.283-kotlin-1.6.10")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:17.0.2-pre.283-kotlin-1.6.10")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:17.0.2-pre.283-kotlin-1.6.10")
    implementation("com.github.grantas33:kotlin-pwa-components:v0.1.2")
    implementation(npm("react-loader-spinner", "4.0.0"))
}

kotlin {
    js {
        browser {
            binaries.executable()
        }
    }
}

tasks["browserDevelopmentRun"].dependsOn(":serviceWorker:copyDevelopmentWebpackToClient")