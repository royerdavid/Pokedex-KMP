package royerdavid.pokedex.app.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import royerdavid.pokedex.app.domain.PokemonsRepository
import royerdavid.pokedex.app.domain.model.PokemonSummary
import royerdavid.pokedex.core.util.Resource
import royerdavid.pokedex.core.util.copyEnqueueDistinct


class PokemonListViewModel(
    private val repository: PokemonsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(PokemonListState())
    val uiState = _uiState.asStateFlow()

    private var searchJob: Job? = null

    init {
        getPokemons()
    }

    fun onAction(event: PokemonListAction) {
        when (event) {
            is PokemonListAction.OnItemClick ->
                onItemClick(event.pokemonSummary)

            is PokemonListAction.OnSearchQueryChange -> {
                _uiState.value = _uiState.value.copy(searchQuery = event.query)
                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    delay(500L)
                    getPokemons()
                }
            }

            PokemonListAction.Refresh ->
                getPokemons(fetchFromRemote = true)

            PokemonListAction.OnTransientMessagesClear ->
                clearTransientMessageQueue()
        }
    }

    private fun getPokemons(fetchFromRemote: Boolean = false) {
        val query = _uiState.value.searchQuery.lowercase()

        viewModelScope.launch {
            repository
                .getPokemonSummaries(fetchFromRemote, query)
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            result.data?.let { listings ->
                                _uiState.value = _uiState.value.copy(pokemons = listings)
                            }
                        }

                        is Resource.Error -> {
                            _uiState.value = _uiState.value.copy(
                                transientMessages = _uiState.value.transientMessages.copyEnqueueDistinct(
                                    result.exception?.message ?: "TODO: display nice error here"
                                )
                            )
                        }

                        is Resource.Loading -> {
                            _uiState.value = _uiState.value.copy(isLoading = result.isLoading)
                        }
                    }
                }
        }
    }

    @Suppress("UNUSED_PARAMETER")
    private fun onItemClick(pokemonSummary: PokemonSummary) {
        _uiState.value = _uiState.value.copy(
            transientMessages = _uiState.value.transientMessages.copyEnqueueDistinct(
                "TODO. Implement details screen"
            )
        )
    }

    private fun clearTransientMessageQueue() {
        _uiState.value = _uiState.value.copy(transientMessages = emptyList())
    }
}
