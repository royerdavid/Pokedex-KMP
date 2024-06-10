package royerdavid.pokedex.app.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.action_refresh
import royerdavid.pokedex.APP_NAME
import royerdavid.pokedex.app.domain.model.PokemonSummary
import royerdavid.pokedex.app.presentation.components.PokemonItem
import royerdavid.pokedex.app.presentation.components.SearchTextField
import royerdavid.pokedex.core.ui.component.DesktopVerticalScrollbar
import royerdavid.pokedex.core.ui.component.handleSnackbarMessages
import royerdavid.pokedex.di.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PokemonListScreen() {
    val viewModel = koinViewModel<PokemonListViewModel>()
    val onAction = viewModel::onAction
    val snackbarHostState = remember { SnackbarHostState() }
    val uiState by viewModel.uiState.collectAsState()

    handleSnackbarMessages(
        snackbarHostState = snackbarHostState,
        userMessages = uiState.userMessages,
        onUserMessagesClear = { onAction(PokemonListAction.OnUserMessagesClear) }
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(APP_NAME)
                },
                actions = {
                    IconButton(
                        onClick = {
                            onAction(PokemonListAction.Refresh)
                        }) {
                        Icon(
                            imageVector = Icons.Filled.Refresh,
                            contentDescription = stringResource(Res.string.action_refresh)
                        )
                    }
                },
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
    ) { innerPadding ->
        val searchText by viewModel.searchText.collectAsState()
        val pokemons by viewModel.pokemons.collectAsState()

        Box(
            modifier = Modifier.padding(top = innerPadding.calculateTopPadding())
        ) {
            Column {
                SearchTextField(
                    value = searchText,
                    onValueChange = { newText -> onAction(PokemonListAction.OnSearchText(newText)) },
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp)
                )

                Spacer(modifier = Modifier.size(4.dp))

                PokemonList(
                    uiState = uiState,
                    onAction = onAction,
                    pokemons = pokemons
                )
            }
        }
    }
}

@Composable
fun PokemonList(
    uiState: PokemonListState,
    onAction: (PokemonListAction) -> Unit,
    pokemons: List<PokemonSummary>,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        // Loading
        if (uiState.isLoading) {
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
            )
        }

        // List items
        val lazyGridState: LazyGridState = rememberLazyGridState()
        LazyVerticalGrid(
            state = lazyGridState,
            columns = GridCells.Adaptive(160.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            items(pokemons.size) { i ->
                PokemonItem(
                    pokemon = pokemons[i],
                    onAction = onAction
                )
            }
        }
        DesktopVerticalScrollbar(
            modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
            lazyGridState = lazyGridState
        )
    }
}
