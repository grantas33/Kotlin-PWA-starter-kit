# Kotlin PWA starter-kit

Create progressive web apps using 100% Kotlin.

Starter-kit PWA features include:
* Button to subscribe/unsubscribe to web push notifications on supported browsers
* Offline work
* "Add to home page" functionality on mobile devices


## Get started

Run app: `./gradlew run`

Run app with hot reload: `./gradlew run --continuous` _*will not hot reload service worker_

Build for production: `./gradlew build`. The bundled files reside in `build/distributions` directory.

## Overview

This starter kit is a Gradle project that uses the Kotlin/JS Gradle plugin and consists of two modules - client and service worker.

Both modules use Kotlin Coroutines library to handle asynchronous operations in a way idiomatic to Kotlin.

Client module includes [React](https://github.com/JetBrains/kotlin-wrappers/tree/master/kotlin-react) and [styled-components](https://github.com/JetBrains/kotlin-wrappers/tree/master/kotlin-styled) libraries wrapped in Kotlin. 
