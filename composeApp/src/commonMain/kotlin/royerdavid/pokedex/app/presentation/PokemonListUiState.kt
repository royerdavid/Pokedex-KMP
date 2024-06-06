package royerdavid.pokedex.app.presentation

import androidx.compose.runtime.Immutable

@Immutable
data class PokemonListUiState(
    val isLoading: Boolean = false,
    val isSearching: Boolean = false,
    val userMessage: String? = null
)
