package royerdavid.pokedex.app.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class NamedApiResourceDto(
    val name: String,
    val url: String
)
