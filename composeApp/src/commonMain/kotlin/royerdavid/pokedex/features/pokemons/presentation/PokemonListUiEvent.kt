package royerdavid.pokedex.features.pokemons.presentation

import royerdavid.pokedex.features.pokemons.domain.model.PokemonSummary


sealed interface PokemonListUiEvent {
    data object Refresh : PokemonListUiEvent
    data class OnPokemonClick(val pokemonSummary: PokemonSummary) : PokemonListUiEvent
}
