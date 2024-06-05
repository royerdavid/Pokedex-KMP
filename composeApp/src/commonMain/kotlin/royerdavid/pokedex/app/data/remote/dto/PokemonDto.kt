package royerdavid.pokedex.app.data.remote.dto

import kotlinx.serialization.Serializable
import royerdavid.pokedex.app.data.local.entity.PokemonEntity


@Serializable
data class PokemonsRootDto(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<NamedApiResource>
)

@Serializable
data class NamedApiResource(
    val name: String,
    val url: String
)

fun NamedApiResource.toPokemonEntity(): PokemonEntity {
    val number = url.split("/").dropLast(1).last()

    return PokemonEntity(
        id = number,
        name = name,
        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$number.png"
    )
}