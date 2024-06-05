package royerdavid.pokedex.app.di

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.dsl.module
import royerdavid.pokedex.app.data.PokemonsRepositoryImpl
import royerdavid.pokedex.app.data.local.PokemonDatabase
import royerdavid.pokedex.app.data.remote.PokemonsApi
import royerdavid.pokedex.app.domain.PokemonsRepository


val appModule = module {
    single<PokemonsRepository> {
        PokemonsRepositoryImpl(get(), get())
    }

    single {
        PokemonsApi(get())
    }

    single {
        getPokemonsDatabase(get())
    }

    single {
        get<PokemonDatabase>().dao
    }

    includes(appPlatformModule)
}

private fun getPokemonsDatabase(
    builder: RoomDatabase.Builder<PokemonDatabase>
): PokemonDatabase {
    return builder
        .fallbackToDestructiveMigration(true)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
