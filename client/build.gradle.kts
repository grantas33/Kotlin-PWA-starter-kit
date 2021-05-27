repositories {
    maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin-wrappers:kotlin-styled:5.3.0-pre.204-kotlin-1.5.0")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:17.0.2-pre.204-kotlin-1.5.0")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:17.0.2-pre.204-kotlin-1.5.0")
    implementation(npm("react-loader-spinner", "3.1.14"))
}

kotlin {
    js {
        browser {
            binaries.executable()
        }
    }
}