package royerdavid.pokedex.app.presentation

import androidx.compose.runtime.Immutable
import royerdavid.pokedex.app.domain.model.PokemonSummary

@Immutable
data class PokemonListUiState(
    val emptyStateText: String = "",
    val isLoading: Boolean = false,
    val pokemonSummaryList: List<PokemonSummary> = emptyList()
)
