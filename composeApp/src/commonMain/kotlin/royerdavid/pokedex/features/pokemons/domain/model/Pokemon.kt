package royerdavid.pokedex.features.pokemons.domain.model

data class Pokemon(
    val id: String,
    val name: String,
    val smallImageUrl: String? = null,
    val largeImageUrl: String? = null
)
