# Pokedex

This project serves as a sandbox to experiment with new functionalities of *Kotlin Multiplatform*.

## Features

- **Platforms:** 
  - Android
  - Desktop
  - iOS (see limitations bellow)
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

- **UI:** Compose Multiplatform
- **Dependency Injection:** Koin
- **Networking:** Ktor
- **Image Loading:** Coil
- **Storage:** Room
- **Serialization:** kotlinx.serialization
- **Concurrency:** Coroutines

## Architecture

- **Pattern:** Clean Architecture
- **State Management:** Model-View-Intent (MVI)

## Limitations

- **iOS:** I cannot compile and test the project as Currently not supported as I don't have a Mac.

## Future Improvements

- Implement unit tests
- Add a logger
- Improve network logs
- Implement pagination
- Put back the details screen from original Android project
- Add search functionality
- Implement sorting & filters
- Add an app bar
- Add a refresh button
- Introduce a use cases layer
