package royerdavid.pokedex.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import royerdavid.pokedex.core.data.getDatabaseBuilder
import royerdavid.pokedex.features.employees.data.local.PokemonDatabase
import royerdavid.pokedex.features.employees.data.local.POKEMON_DATABASE_FILE_NAME
import royerdavid.pokedex.features.employees.presentation.PokemonListViewModel

actual val platformModule = module {
    singleOf(::PokemonListViewModel)

    single {
        getDatabaseBuilder<PokemonDatabase>(POKEMON_DATABASE_FILE_NAME)
    }
}
