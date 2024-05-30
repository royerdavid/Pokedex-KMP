package royerdavid.pokedex.features.employees.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonsRootDto(
    @SerialName("employees") val employees: List<PokemonDto>
)
