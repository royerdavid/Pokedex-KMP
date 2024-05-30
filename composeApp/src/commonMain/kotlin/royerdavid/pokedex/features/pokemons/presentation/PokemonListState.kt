package royerdavid.pokedex.features.pokemons.presentation

import androidx.compose.runtime.Immutable
import royerdavid.pokedex.features.pokemons.domain.model.Pokemon

@Immutable
data class PokemonListState(
    val emptyStateText: String = "",
    val isLoading: Boolean = false,
    val pokemonList: List<Pokemon> = emptyList()
)
