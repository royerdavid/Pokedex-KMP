package royerdavid.pokedex.features.employees.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import royerdavid.pokedex.features.employees.domain.model.Pokemon
import royerdavid.pokedex.features.employees.domain.model.PokemonType

@Entity
data class PokemonEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val phoneNumber: String? = null,
    val email: String,
    val biography: String? = null,
    val smallImageUrl: String? = null,
    val largeImageUrl: String? = null,
    val team: String,
    val pokemonType: PokemonType
) {
    fun toPokemon() = Pokemon(
        id = id,
        name = name,
        phoneNumber = phoneNumber,
        email = email,
        biography = biography,
        smallImageUrl = smallImageUrl,
        largeImageUrl = largeImageUrl,
        team = team,
        pokemonType = pokemonType
    )
}
