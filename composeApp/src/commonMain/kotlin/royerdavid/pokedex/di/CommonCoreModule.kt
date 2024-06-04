package royerdavid.pokedex.di

import org.koin.dsl.module
import royerdavid.pokedex.APP_NAME
import royerdavid.pokedex.core.data.api.createHttpClient
import royerdavid.pokedex.core.util.KermitLogger
import royerdavid.pokedex.core.util.Logger

/**
 * Platform independent core module
 */
val coreModule = module {
    single<Logger> { KermitLogger(APP_NAME) }
    single { createHttpClient(get()) }
}
