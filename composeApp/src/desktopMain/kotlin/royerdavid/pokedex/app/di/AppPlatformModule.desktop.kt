package royerdavid.pokedex.app.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import royerdavid.pokedex.app.data.local.POKEMON_DATABASE_FILE_NAME
import royerdavid.pokedex.app.data.local.PokemonDatabase
import royerdavid.pokedex.app.presentation.PokemonListViewModel
import royerdavid.pokedex.core.data.getDatabaseBuilder

actual val appPlatformModule = module {
    singleOf(::PokemonListViewModel)

    single {
        getDatabaseBuilder<PokemonDatabase>(POKEMON_DATABASE_FILE_NAME)
    }
}
