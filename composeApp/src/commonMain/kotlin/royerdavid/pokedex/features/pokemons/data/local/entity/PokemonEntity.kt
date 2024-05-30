package royerdavid.pokedex.features.pokemons.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import royerdavid.pokedex.features.pokemons.domain.model.Pokemon

@Entity
data class PokemonEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val smallImageUrl: String? = null,
    val largeImageUrl: String? = null
) {
    fun toPokemon() = Pokemon(
        id = id,
        name = name,
        smallImageUrl = smallImageUrl,
        largeImageUrl = largeImageUrl
    )
}
