package royerdavid.pokedex.features.employees.presentation

import royerdavid.pokedex.features.employees.domain.model.Pokemon

data class PokemonListState(
    val emptyStateText: String = "",
    val isLoading: Boolean = false,
    val pokemonList: List<Pokemon> = emptyList()
)
