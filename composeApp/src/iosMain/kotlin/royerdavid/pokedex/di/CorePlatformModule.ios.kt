package royerdavid.pokedex.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import royerdavid.pokedex.core.data.getDatabaseBuilder
import royerdavid.pokedex.features.pokemons.data.local.POKEMON_DATABASE_FILE_NAME
import royerdavid.pokedex.features.pokemons.data.local.PokemonDatabase
import royerdavid.pokedex.features.pokemons.presentation.PokemonListViewModel

actual val corePlatformModule = module {
    singleOf(::PokemonListViewModel)

    single {
        getDatabaseBuilder<PokemonDatabase>(POKEMON_DATABASE_FILE_NAME)
    }
}
