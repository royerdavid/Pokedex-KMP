package royerdavid.pokedex.features.employees.domain.model

data class Pokemon(
    val id: String,
    val name: String,
    val phoneNumber: String? = null,
    val email: String,
    val biography: String? = null,
    val smallImageUrl: String? = null,
    val largeImageUrl: String? = null,
    val team: String,
    val pokemonType: PokemonType
)
