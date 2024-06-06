package royerdavid.pokedex.app.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.serialization.SerializationException
import org.jetbrains.compose.resources.getString
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.error_invalid_response
import pokedex.composeapp.generated.resources.error_no_items_found
import pokedex.composeapp.generated.resources.error_unexpected
import royerdavid.pokedex.app.domain.PokemonsRepository
import royerdavid.pokedex.app.domain.model.PokemonSummary
import royerdavid.pokedex.app.domain.model.doesMatchSearchQuery
import royerdavid.pokedex.core.util.Resource


@OptIn(FlowPreview::class)
class PokemonListViewModel(
    private val pokemonsRepository: PokemonsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(PokemonListUiState(isLoading = true))
    val uiState = _uiState.asStateFlow()

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _pokemons = MutableStateFlow(listOf<PokemonSummary>())
    val pokemons = searchText
        .debounce(200)
        .onEach {
            _uiState.value =
                uiState.value.copy(isSearching = true)
        }
        .combine(_pokemons) { text, allPokemons ->
            if (text.isBlank()) {
                allPokemons
            } else {
                allPokemons.filter {
                    it.doesMatchSearchQuery(text)
                }
            }
        }
        .onEach {
            _uiState.value = uiState.value.copy(
                emptyStateText = if (!uiState.value.isLoading && it.isEmpty()) {
                    getString(Res.string.error_no_items_found)
                } else {
                    ""
                },
                isSearching = false
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = _pokemons.value
        )

    init {
        fetchPokemons()
    }

    private fun fetchPokemons() {
        viewModelScope.launch {
            pokemonsRepository.getPokemons().onEach { resource ->
                when (resource) {
                    is Resource.Success -> {
                        _uiState.value = uiState.value.copy(
                            isLoading = false,
                            emptyStateText = if (resource.data.isNullOrEmpty()) {
                                getString(Res.string.error_no_items_found)

                            } else {
                                ""
                            }
                        )
                        _pokemons.value = resource.data ?: emptyList()
                    }

                    is Resource.Error -> {
                        _uiState.value = uiState.value.copy(
                            isLoading = false,
                            emptyStateText = if (resource.exception is SerializationException) {
                                getString(Res.string.error_invalid_response)
                            } else {
                                getString(Res.string.error_unexpected)
                            }
                        )

                        _pokemons.value = resource.data ?: emptyList()
                    }

                    is Resource.Loading -> {
                        _uiState.value = uiState.value.copy(
                            isLoading = true,
                        )

                        resource.data?.let {
                            _pokemons.value = it
                        }
                    }
                }
            }.launchIn(this)
        }
    }

    fun onUiEvent(event: PokemonListUiEvent) {
        when (event) {
            is PokemonListUiEvent.OnItemClick -> Unit // TODO
            PokemonListUiEvent.Refresh -> fetchPokemons()
            is PokemonListUiEvent.OnSearchText -> _searchText.value = event.text
        }
    }
}
