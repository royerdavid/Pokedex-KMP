package royerdavid.pokedex.features.pokemons.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonsRootDto(
    @SerialName("data") val data: List<PokemonDto>
)
