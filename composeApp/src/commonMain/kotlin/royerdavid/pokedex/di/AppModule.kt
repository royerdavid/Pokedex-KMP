package royerdavid.pokedex.di

import commonModule
import royerdavid.pokedex.features.pokemons.di.pokemonsModule

fun appModule() = listOf(
    commonModule,
    pokemonsModule,
    platformModule
)
