package royerdavid.pokedex.features.pokemons.data.remote.dto

import kotlinx.serialization.Serializable
import royerdavid.pokedex.features.pokemons.data.local.entity.PokemonEntity


@Serializable
data class PokemonsRootDto(
    val data: List<PokemonDto>
)

@Serializable
data class PokemonDto(
    val id: String,
    val name: String,
    val images: ImagesDto?
)

@Serializable
data class ImagesDto(
    val small: String,
    val large: String
)

fun PokemonDto.toPokemonEntity() = PokemonEntity(
    id = id,
    name = name,
    smallImageUrl = images?.small,
    largeImageUrl = images?.large
)
