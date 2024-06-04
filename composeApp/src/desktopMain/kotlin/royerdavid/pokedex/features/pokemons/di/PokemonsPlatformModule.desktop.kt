package royerdavid.pokedex.features.pokemons.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import royerdavid.pokedex.core.data.getDatabaseBuilder
import royerdavid.pokedex.features.pokemons.data.local.POKEMON_DATABASE_FILE_NAME
import royerdavid.pokedex.features.pokemons.data.local.PokemonDatabase
import royerdavid.pokedex.features.pokemons.presentation.PokemonListViewModel

actual val pokemonsPlatformModule = module {
    singleOf(::PokemonListViewModel)

    single {
        getDatabaseBuilder<PokemonDatabase>(POKEMON_DATABASE_FILE_NAME)
    }
}
