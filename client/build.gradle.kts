repositories {
    maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("org.jetbrains:kotlin-styled:1.0.0-pre.110-kotlin-1.4.10")
    implementation("org.jetbrains:kotlin-react:16.13.1-pre.110-kotlin-1.4.10")
    implementation("org.jetbrains:kotlin-react-dom:16.13.1-pre.110-kotlin-1.4.10")
    implementation(npm("react-loader-spinner", "3.1.14"))
}

kotlin {
    js {
        browser {
            binaries.executable()
        }
    }
}