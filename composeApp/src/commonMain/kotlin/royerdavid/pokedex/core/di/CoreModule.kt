package royerdavid.pokedex.core.di

import org.koin.core.module.Module
import org.koin.dsl.module
import royerdavid.pokedex.APP_NAME
import royerdavid.pokedex.app.data.remote.createHttpClient
import royerdavid.pokedex.core.util.KermitLogger
import royerdavid.pokedex.core.util.Logger


/**
 * Platform independent core module
 */
val coreModule = module {
    single<Logger> { KermitLogger(APP_NAME) }
    single { createHttpClient(get()) }
}

/**
 * Platform specific core module
 */
expect val corePlatformModule: Module
