package royerdavid.pokedex.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonSummaryEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val imageUrl: String? = null
)
