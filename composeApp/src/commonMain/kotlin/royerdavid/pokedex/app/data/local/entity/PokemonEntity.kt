package royerdavid.pokedex.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val imageUrl: String? = null
)
