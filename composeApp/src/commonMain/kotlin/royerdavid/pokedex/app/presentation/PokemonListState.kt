package royerdavid.pokedex.app.presentation

import androidx.compose.runtime.Immutable

@Immutable
data class PokemonListState(
    val isLoading: Boolean = false,
    val isSearching: Boolean = false,
    val userMessages: List<String> = emptyList()
)
