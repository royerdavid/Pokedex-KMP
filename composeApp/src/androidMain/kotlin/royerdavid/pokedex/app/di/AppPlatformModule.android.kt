package royerdavid.pokedex.app.di

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import royerdavid.pokedex.app.data.local.POKEMON_DATABASE_FILE_NAME
import royerdavid.pokedex.app.data.local.PokemonDatabase
import royerdavid.pokedex.app.presentation.PokemonListViewModel
import royerdavid.pokedex.core.data.getDatabaseBuilder

actual val appPlatformModule = module {
    viewModelOf(::PokemonListViewModel)

    single {
        getDatabaseBuilder<PokemonDatabase>(androidContext(), POKEMON_DATABASE_FILE_NAME)
    }
}
