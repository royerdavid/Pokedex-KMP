package royerdavid.pokedex.features.pokemons.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import royerdavid.pokedex.features.pokemons.domain.model.PokemonSummary

@Entity
data class PokemonEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val imageUrl: String? = null
) {
    fun toPokemon() = PokemonSummary(
        id = id,
        name = name,
        imageUrl = imageUrl
    )
}
