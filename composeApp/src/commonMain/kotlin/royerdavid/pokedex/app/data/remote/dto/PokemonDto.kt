package royerdavid.pokedex.app.data.remote.dto

import kotlinx.serialization.Serializable


@Serializable
data class PokemonsRootDto(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<NamedApiResourceDto>
)
