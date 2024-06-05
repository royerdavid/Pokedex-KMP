package royerdavid.pokedex.app.data.remote.dto

import kotlinx.serialization.Serializable
import royerdavid.pokedex.app.data.local.entity.PokemonEntity

@Serializable
data class NamedApiResourceDto(
    val name: String,
    val url: String
) {
    fun toPokemonEntity(): PokemonEntity {
        val number = url.split("/").dropLast(1).last()

        return PokemonEntity(
            id = number,
            name = name,
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$number.png"
        )
    }
}
