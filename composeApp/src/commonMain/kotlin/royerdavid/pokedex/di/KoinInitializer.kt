package royerdavid.pokedex.di

import co.touchlab.kermit.Logger
import co.touchlab.kermit.koin.KermitKoinLogger
import org.koin.core.KoinApplication

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class KoinInitializer {
    fun init()
}

internal fun KoinApplication.koinLogs() {
    // Logs what Koin does
    logger(
        KermitKoinLogger(Logger.withTag("koin"))
    )
}
