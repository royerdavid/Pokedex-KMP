package royerdavid.pokedex.features.employees.di

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.dsl.module
import royerdavid.pokedex.features.employees.data.PokemonsRepositoryImpl
import royerdavid.pokedex.features.employees.data.local.PokemonDatabase
import royerdavid.pokedex.features.employees.data.remote.PokemonsApi
import royerdavid.pokedex.features.employees.domain.PokemonsRepository


val pokemonsModule = module {

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
