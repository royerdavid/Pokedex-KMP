package royerdavid.pokedex.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import royerdavid.pokedex.app.data.local.entity.PokemonEntity

const val POKEMON_DATABASE_FILE_NAME = "pokemon.db"

@Database(
    entities = [PokemonEntity::class],
    version = 2
)
abstract class PokemonDatabase : RoomDatabase() {
    abstract val dao: PokemonsDao
}
