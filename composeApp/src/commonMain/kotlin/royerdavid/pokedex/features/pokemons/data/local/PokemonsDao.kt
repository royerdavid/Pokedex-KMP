package royerdavid.pokedex.features.pokemons.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import royerdavid.pokedex.features.pokemons.data.local.entity.PokemonEntity

@Dao
interface PokemonsDao {
    @Query("SELECT * FROM PokemonEntity")
    suspend fun getAll(): List<PokemonEntity>

    @Query("SELECT * FROM PokemonEntity WHERE id=:id")
    suspend fun getById(id: String): PokemonEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemonEntityList: List<PokemonEntity>)
}