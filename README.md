# Pokedex

This project is mainly a sandbox to play with new functionalities of *Kotlin Multiplatform*.

## Features

- **Platforms:** Android & Desktop
- **Display:** Small & large (resizable in Desktop)
- **Orientations:** Portrait & landscape
- **Display modes:** Dark & light modes
- **Localization:** English & French
- **Others:**
    - Caching for offline mode, faster loading and error fallback

## How to run

Run "*composeApp*" configuration:

- [Android](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-multiplatform-create-first-app.html#run-your-application-on-android)
- [Desktop](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-multiplatform-create-first-app.html#run-your-application-on-desktop)

## Technology used

- **UI:** Compose multiplatform
- **Dependency injection:** Koin
- **Networking:** Ktor
- **Image loading:** Coil
- **Storage:** Room
- **Serialization:** kotlinx.serialization
- **Concurrency:** Coroutines

## Architecture

- Clean architecture
- MVI

## Limitations

- **iOS**: I don't have a Mac to compile & test the project.

## Improvements ideas

- Unit tests
- Add a logger
- Network logs
- Grid pagination
- Details screen
- Search
- Sorting & filters
- App bar
- Refresh button
- Use cases layer
