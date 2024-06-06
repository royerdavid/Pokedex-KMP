package royerdavid.pokedex.app.data.mappers

import royerdavid.pokedex.app.data.local.entity.PokemonEntity
import royerdavid.pokedex.app.data.remote.dto.NamedApiResourceDto
import royerdavid.pokedex.app.domain.model.PokemonSummary

fun PokemonEntity.toPokemon() = PokemonSummary(
    id = id,
    name = name,
    imageUrl = imageUrl
)

fun NamedApiResourceDto.toPokemonEntity(): PokemonEntity {
    val number = url.split("/").dropLast(1).last()

    return PokemonEntity(
        id = number,
        name = name,
        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$number.png"
    )
}