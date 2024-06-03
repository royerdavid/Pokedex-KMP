package royerdavid.pokedex.di

import royerdavid.pokedex.features.pokemons.di.pokemonsModule

fun appModule() = listOf(
    // Main modules
    commonModule,
    platformModule,

    // Features module
    pokemonsModule
)
