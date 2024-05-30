package royerdavid.pokedex.features.pokemons.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import royerdavid.pokedex.di.koinViewModel
import royerdavid.pokedex.features.pokemons.domain.model.Pokemon


@Composable
fun PokemonListScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
        val viewModel = koinViewModel<PokemonListViewModel>()

        PokemonList(
            state = viewModel.state.collectAsState().value,
            onItemClick = { pokemon ->
                // TODO
            })
    }
}

@Composable
fun PokemonList(
    state: PokemonListState,
    onItemClick: (Pokemon) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        val itemsSize = state.pokemonList.size

        if (itemsSize > 0) {
            // List items
            LazyVerticalGrid(
                columns = GridCells.Adaptive(160.dp),
                contentPadding = PaddingValues(8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                items(itemsSize) { i ->
                    val pokemon = state.pokemonList[i]

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .clickable {
                                onItemClick(pokemon)
                            }
                            .padding(horizontal = 16.dp, vertical = 10.dp)
                    ) {
                        AsyncImage(
                            // Min size to reduce cell jumping when images are loaded
                            modifier = Modifier.defaultMinSize(minHeight = 128.dp),
                            model = pokemon.smallImageUrl,
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(
                            text = pokemon.name,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        } else if (state.emptyStateText.isNotBlank()) {
            // Empty state
            Text(
                text = state.emptyStateText,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        // Loading
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
