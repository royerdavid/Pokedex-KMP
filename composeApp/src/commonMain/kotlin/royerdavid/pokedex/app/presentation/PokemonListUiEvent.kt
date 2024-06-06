package royerdavid.pokedex.app.presentation

import royerdavid.pokedex.app.domain.model.PokemonSummary

sealed interface PokemonListUiEvent {
    data object Refresh : PokemonListUiEvent
    data class OnItemClick(val pokemonSummary: PokemonSummary) : PokemonListUiEvent
    data class OnSearchText(val text: String) : PokemonListUiEvent
}
