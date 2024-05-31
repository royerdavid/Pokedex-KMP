package royerdavid.pokedex.features.pokemons.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.network_refresh
import royerdavid.pokedex.core.ui.component.DesktopVerticalScrollbar
import royerdavid.pokedex.di.koinViewModel
import royerdavid.pokedex.features.pokemons.domain.model.Pokemon

@Preview
@Composable
fun PokemonListScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
        val viewModel = koinViewModel<PokemonListViewModel>()

        PokemonList(
            state = viewModel.state.collectAsState().value,
            onItemClick = { _ ->
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
            val lazyGridState: LazyGridState = rememberLazyGridState()

            // List items
            LazyVerticalGrid(
                state = lazyGridState,
                columns = GridCells.Adaptive(160.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 24.dp),
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
            DesktopVerticalScrollbar(
                modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
                lazyGridState = lazyGridState
            )
        } else if (state.emptyStateText.isNotBlank()) {
            // Empty state
            Text(
                text = state.emptyStateText,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        // Loading
        if (state.isLoading) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LinearProgressIndicator(
                    modifier = Modifier.fillMaxWidth(),
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.secondaryContainer),
                    text = stringResource(Res.string.network_refresh),
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
