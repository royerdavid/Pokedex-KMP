package royerdavid.pokedex.app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import royerdavid.pokedex.app.data.local.entity.PokemonSummaryEntity

@Dao
interface PokemonsDao {
    @Query("SELECT * FROM PokemonSummaryEntity WHERE id=:id")
    suspend fun getPokemonSummaryById(id: Int): PokemonSummaryEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonSummaries(pokemonSummaryEntityList: List<PokemonSummaryEntity>)

    @Query("DELETE FROM PokemonSummaryEntity")
    suspend fun clearPokemonSummaries()

    @Query(
        """
            SELECT * 
            FROM PokemonSummaryEntity
            WHERE LOWER(name) LIKE '%' || LOWER(:query) || '%' 
        """
    )
    suspend fun searchPokemonSummaries(query: String): List<PokemonSummaryEntity>
}
