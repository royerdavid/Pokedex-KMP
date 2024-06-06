package royerdavid.pokedex.app.presentation

import androidx.compose.runtime.Immutable

@Immutable
data class PokemonListUiState(
    val emptyStateText: String = "",
    val isLoading: Boolean = false,
    val isSearching: Boolean = false
)
