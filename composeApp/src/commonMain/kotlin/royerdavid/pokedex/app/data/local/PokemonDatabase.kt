package royerdavid.pokedex.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import royerdavid.pokedex.app.data.local.entity.PokemonSummaryEntity

const val POKEMON_DATABASE_FILE_NAME = "pokemon.db"

@Database(
    entities = [PokemonSummaryEntity::class],
    version = 3
)
abstract class PokemonDatabase : RoomDatabase() {
    abstract val dao: PokemonsDao
}
