package royerdavid.pokedex.app.presentation

import royerdavid.pokedex.app.domain.model.PokemonSummary

sealed interface PokemonListAction {
    data object Refresh : PokemonListAction
    data object OnUserMessagesClear : PokemonListAction
    data class OnItemClick(val pokemonSummary: PokemonSummary) : PokemonListAction
    data class OnSearchText(val text: String) : PokemonListAction
}
