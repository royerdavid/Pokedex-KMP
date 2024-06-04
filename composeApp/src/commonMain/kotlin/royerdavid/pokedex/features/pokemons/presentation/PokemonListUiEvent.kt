package royerdavid.pokedex.features.pokemons.presentation

import royerdavid.pokedex.features.pokemons.domain.model.Pokemon


sealed interface PokemonListUiEvent {
    data object Refresh : PokemonListUiEvent
    data class OnPokemonClick(val pokemon: Pokemon) : PokemonListUiEvent
}
