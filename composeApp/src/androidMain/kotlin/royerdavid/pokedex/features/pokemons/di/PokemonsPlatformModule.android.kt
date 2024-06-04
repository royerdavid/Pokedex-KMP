package royerdavid.pokedex.features.pokemons.di

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import royerdavid.pokedex.core.data.getDatabaseBuilder
import royerdavid.pokedex.features.pokemons.data.local.POKEMON_DATABASE_FILE_NAME
import royerdavid.pokedex.features.pokemons.data.local.PokemonDatabase
import royerdavid.pokedex.features.pokemons.presentation.PokemonListViewModel

actual val pokemonsPlatformModule = module {
    viewModelOf(::PokemonListViewModel)

    single {
        getDatabaseBuilder<PokemonDatabase>(androidContext(), POKEMON_DATABASE_FILE_NAME)
    }
}
