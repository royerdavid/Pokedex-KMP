package royerdavid.pokedex

import org.koin.core.context.startKoin
import royerdavid.pokedex.di.rootModule

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class KoinInitializer {
    actual fun init() {
        startKoin {
            koinLogs()
            modules(rootModule)
        }
    }
}
