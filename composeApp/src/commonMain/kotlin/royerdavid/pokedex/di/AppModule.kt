package royerdavid.pokedex.di

import org.koin.dsl.module
import royerdavid.pokedex.APP_NAME
import royerdavid.pokedex.core.data.api.createHttpClient
import royerdavid.pokedex.core.util.KermitLogger
import royerdavid.pokedex.core.util.Logger
import royerdavid.pokedex.features.pokemons.di.pokemonsModule

val appModule = module {
    single<Logger> { KermitLogger(APP_NAME) }
    single { createHttpClient(get()) }

    includes(
        platformModule,

        // Feature specific modules
        pokemonsModule
    )
}
