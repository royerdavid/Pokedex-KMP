package royerdavid.pokedex.features.employees.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import royerdavid.pokedex.features.employees.data.local.entity.PokemonEntity
import royerdavid.pokedex.features.employees.domain.model.Pokemon
import royerdavid.pokedex.features.employees.domain.model.PokemonType

@Serializable
data class PokemonDto(
    @SerialName("biography") val biography: String?,
    @SerialName("email_address") val emailAddress: String,
    @SerialName("employee_type") val pokemonType: PokemonType,
    @SerialName("full_name") val fullName: String,
    @SerialName("phone_number") val phoneNumber: String?,
    @SerialName("photo_url_large") val photoUrlLarge: String?,
    @SerialName("photo_url_small") val photoUrlSmall: String?,
    @SerialName("team") val team: String,
    @SerialName("uuid") val uuid: String
) {
    fun toEmployeeEntity() = PokemonEntity(
        id = uuid,
        name = fullName,
        phoneNumber = phoneNumber,
        email = emailAddress,
        biography = biography,
        smallImageUrl = photoUrlSmall,
        largeImageUrl = photoUrlLarge,
        team = team,
        pokemonType = pokemonType
    )

    fun toEmployee() = Pokemon(
        id = uuid,
        name = fullName,
        phoneNumber = phoneNumber,
        email = emailAddress,
        biography = biography,
        smallImageUrl = photoUrlSmall,
        largeImageUrl = photoUrlLarge,
        team = team,
        pokemonType = pokemonType
    )
}
