package royerdavid.pokedex.app.data.mappers

import royerdavid.pokedex.app.data.local.entity.PokemonSummaryEntity
import royerdavid.pokedex.app.data.remote.dto.NamedApiResourceDto
import royerdavid.pokedex.app.domain.model.PokemonSummary

fun PokemonSummaryEntity.toModel() = PokemonSummary(
    id = id,
    name = name,
    imageUrl = imageUrl
)

fun NamedApiResourceDto.toEntity(): PokemonSummaryEntity {
    val id = url.trimEnd('/').substringAfterLast('/').toIntOrNull() ?: 0

    url.trimEnd('/')

    return PokemonSummaryEntity(
        id = id,
        name = name,
        imageUrl = getPokemonImageUrl(id)
    )
}

internal fun getPokemonImageUrl(number: Int) =
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$number.png"
