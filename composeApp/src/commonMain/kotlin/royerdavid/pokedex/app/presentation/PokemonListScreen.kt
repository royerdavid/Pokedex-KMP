package royerdavid.pokedex.app.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import pokedex.composeapp.generated.resources.action_refresh
import royerdavid.pokedex.APP_NAME
import royerdavid.pokedex.core.ui.component.DesktopVerticalScrollbar
import royerdavid.pokedex.di.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PokemonListScreen() {
    val viewModel = koinViewModel<PokemonListViewModel>()
    val onUiEvent = viewModel::onUiEvent

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(APP_NAME)
                },
                actions = {
                    IconButton(
                        onClick = {
                            onUiEvent(PokemonListUiEvent.Refresh)
                        }) {
                        Icon(
                            imageVector = Icons.Filled.Refresh,
                            contentDescription = stringResource(Res.string.action_refresh)
                        )
                    }
                },
            )
        },
    ) { innerPadding ->
        PokemonList(
            modifier = Modifier.padding(top = innerPadding.calculateTopPadding()),
            uiState = viewModel.state.collectAsState().value,
            onUiEvent = onUiEvent
        )
    }
}

@Composable
fun PokemonList(
    modifier: Modifier = Modifier,
    uiState: PokemonListUiState,
    onUiEvent: (PokemonListUiEvent) -> Unit
) {
    Box(
        modifier = modifier
    ) {
        val itemsSize = uiState.pokemonSummaryList.size

        if (itemsSize > 0) {
            val lazyGridState: LazyGridState = rememberLazyGridState()
            val imageSize = 160.dp

            // List items
            LazyVerticalGrid(
                state = lazyGridState,
                columns = GridCells.Adaptive(imageSize),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 24.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                items(itemsSize) { i ->
                    val pokemon = uiState.pokemonSummaryList[i]

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .clickable {
                                onUiEvent(PokemonListUiEvent.OnItemClick(pokemon))
                            }
                            .padding(horizontal = 16.dp, vertical = 10.dp)
                    ) {
                        AsyncImage(
                            // Min size to reduce cell jumping when images are loaded
                            modifier = Modifier.requiredSize(imageSize),
                            model = pokemon.imageUrl,
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
        } else if (uiState.emptyStateText.isNotBlank()) {
            // Empty state
            Text(
                text = uiState.emptyStateText,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        // Loading
        if (uiState.isLoading) {
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}
