package royerdavid.pokedex.app.domain.model

data class PokemonSummary(
    val id: Int,
    val name: String,
    val imageUrl: String? = null
)

fun PokemonSummary.doesMatchSearchQuery(query: String): Boolean =
    name.contains(query.trim(), ignoreCase = true)
