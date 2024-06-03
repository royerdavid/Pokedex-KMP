package royerdavid.pokedex.di

import org.koin.core.context.startKoin

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class KoinInitializer {
    actual fun init() {
        startKoin {
            koinLogs()
            modules(appModule)
        }
    }
}
