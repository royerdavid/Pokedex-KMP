# Pokédex-KMP

This project serves as a sandbox to experiment with new functionalities of *Kotlin Multiplatform*.

This small project adopts a complex structure, mirroring the organizational principles of
larger-scale projects.

## Features

- **Platforms:**
    - Android
    - Desktop
- **Display:**
    - Dark & light modes
    - Small & large devices
    - Portrait & landscape
- **Localization:**
    - English
    - French
- **Others:**
    - Caching for offline mode & pre-loading data
  - Search

## How to run

Run the "*composeApp*" configuration for your desired platform:

- [Run on Android](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-multiplatform-create-first-app.html#run-your-application-on-android)
- [Run on Desktop](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-multiplatform-create-first-app.html#run-your-application-on-desktop)

## Technology used

- UI: [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/)
- Dependency Injection: [Koin](https://insert-koin.io/)
- Networking: [Ktor](https://ktor.io/)
- Image Loading: [Coil](https://coil-kt.github.io/coil/)
- Storage: [Room](https://developer.android.com/kotlin/multiplatform/room)
- Serialization: [kotlinx.serialization](https://kotlinlang.org/docs/serialization.html)
- Concurrency: [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)
- Logging: [Kermit the log](https://kermit.touchlab.co/docs/)

## Architecture

- **Pattern:** Clean Architecture
- **State Management:** Model-View-Intent (MVI)

## Limitations

- **iOS:** I need a Mac to build the project to make sure it works on iOS.

## Future Improvements

- Create unit tests
- Put back the details screen from original Android project
- Split the project in modules
- Introduce a use cases layer
- Display error messages in a "snackbar" instead of an empty state
