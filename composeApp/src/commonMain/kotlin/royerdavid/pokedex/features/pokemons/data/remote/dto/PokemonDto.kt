package royerdavid.pokedex.features.pokemons.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import royerdavid.pokedex.features.pokemons.data.local.entity.PokemonEntity
import royerdavid.pokedex.features.pokemons.domain.model.Pokemon

@Serializable
data class PokemonDto(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String
) {
    fun toPokemonEntity() = PokemonEntity(
        id = id,
        name = name
    )
}
