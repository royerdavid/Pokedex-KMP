package royerdavid.pokedex.app.presentation

import androidx.compose.runtime.Immutable
import royerdavid.pokedex.app.domain.model.PokemonSummary

@Immutable
data class PokemonListState(
    val pokemons: List<PokemonSummary> = emptyList(),
    val isLoading: Boolean = false,
    val searchQuery: String = "",
    val transientMessages: List<String> = emptyList()
)
