package royerdavid.pokedex.features.pokemons.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.serialization.SerializationException
import org.jetbrains.compose.resources.getString
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.error_invalid_response
import pokedex.composeapp.generated.resources.error_no_items_found
import pokedex.composeapp.generated.resources.error_unexpected
import royerdavid.pokedex.core.util.Resource
import royerdavid.pokedex.features.pokemons.domain.PokemonsRepository


class PokemonListViewModel(
    private val pokemonsRepository: PokemonsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(PokemonListState(isLoading = true))
    val state = _state.asStateFlow()

    init {
        loadPokemons()
    }

    private fun loadPokemons() {
        viewModelScope.launch {
            pokemonsRepository.getPokemons().onEach { resource ->
                when (resource) {
                    is Resource.Success ->
                        _state.value = state.value.copy(
                            isLoading = false,
                            emptyStateText = if (resource.data.isNullOrEmpty()) {
                                getString(Res.string.error_no_items_found)

                            } else {
                                ""
                            },
                            pokemonList = resource.data ?: emptyList()
                        )

                    is Resource.Error ->
                        _state.value = state.value.copy(
                            isLoading = false,
                            emptyStateText = if (resource.exception is SerializationException) {
                                getString(Res.string.error_invalid_response)
                            } else {
                                getString(Res.string.error_unexpected)
                            },
                            pokemonList = resource.data ?: emptyList()
                        )

                    is Resource.Loading ->
                        _state.value = state.value.copy(
                            isLoading = true,
                            pokemonList = resource.data ?: state.value.pokemonList
                        )
                }
            }.launchIn(this)
        }
    }
}
