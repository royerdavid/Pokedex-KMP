package royerdavid.pokedex.di

import org.koin.dsl.module
import royerdavid.pokedex.features.pokemons.di.pokemonsModule


val appModule = module {
    includes(
        coreModule,
        corePlatformModule,

        // Feature specific modules
        pokemonsModule
    )
}
