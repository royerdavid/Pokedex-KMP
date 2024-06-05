package royerdavid.pokedex.core.di

import org.koin.core.module.Module
import org.koin.dsl.module
import royerdavid.pokedex.core.network.createHttpClient
import royerdavid.pokedex.core.util.KermitLogger
import royerdavid.pokedex.core.util.Logger


/**
 * Platform independent core module
 */
fun coreModule(appName: String) = module {
    single<Logger> {
        KermitLogger(appName)
    }

    single {
        createHttpClient(get())
    }

    includes(corePlatformModule)
}

/**
 * Platform specific core module
 */
expect val corePlatformModule: Module
