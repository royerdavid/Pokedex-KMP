# Pokedex

This project serves as a sandbox to experiment with new functionalities of *Kotlin Multiplatform*.

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

## How to run

Run the "*composeApp*" configuration for your desired platform:

- [Run on Android](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-multiplatform-create-first-app.html#run-your-application-on-android)
- [Run on Desktop](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-multiplatform-create-first-app.html#run-your-application-on-desktop)

## Technology used

- **UI:** [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/)
- **Dependency Injection:** [Koin](https://insert-koin.io/)
- **Networking:** [Ktor](https://ktor.io/)
- **Image Loading:** [Coil](https://coil-kt.github.io/coil/)
- **Storage:** [Room](https://developer.android.com/kotlin/multiplatform/room)
- **Serialization:** [kotlinx.serialization](https://kotlinlang.org/docs/serialization.html)
- **Concurrency:** [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)
- **Logging:** [Kermit the log](https://kermit.touchlab.co/docs/)

## Architecture

- **Pattern:** Clean Architecture
- **State Management:** Model-View-Intent (MVI)

## Limitations

- **iOS:** I cannot compile and test the project as Currently not supported as I don't have a Mac.

## Future Improvements

- Implement unit tests
- Split the project in modules
- Implement pagination
- Put back the details screen from original Android project
- Add search functionality
- Implement sorting & filters
- Add an app bar
- Add a refresh button
- Introduce a use cases layer
