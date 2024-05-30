package royerdavid.pokedex.di

import commonModule
import royerdavid.pokedex.features.employees.di.pokemonsModule

fun appModule() = listOf(
    commonModule,
    pokemonsModule,
    platformModule
)
