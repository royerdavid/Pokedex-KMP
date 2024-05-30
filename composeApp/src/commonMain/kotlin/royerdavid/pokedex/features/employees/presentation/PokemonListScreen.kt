package royerdavid.pokedex.features.employees.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import royerdavid.pokedex.di.koinViewModel
import royerdavid.pokedex.features.employees.domain.model.Pokemon


@Composable
fun PokemonListScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
        val viewModel = koinViewModel<PokemonListViewModel>()

        PokemonList(
            state = viewModel.state.collectAsState().value,
            onItemClick = { pokemon ->
//            navigator.navigateTo(
//                pane = ListDetailPaneScaffoldRole.Detail,
//                content = employee.id
//            )
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
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                itemsIndexed(
                    items = state.pokemonList,
                    key = { _, employee ->
                        employee.id
                    },
                ) { index, employee ->
                    ListItem(
                        modifier = Modifier.clickable {
                            onItemClick(employee)
                        },
                        headlineContent = { Text(employee.name) },
                        supportingContent = { Text(employee.team) },
                        leadingContent = {
                            Text("Image")
                        })

                    if (index < itemsSize - 1) {
                        HorizontalDivider()
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

//@Preview(showSystemUi = true)
//@Composable
//fun EmployeeListLoadingPreview() {
//    EmployeeList(
//        EmployeeListState(isLoading = true),
//        onItemClick = {}
//    )
//}
//
//@Preview(showSystemUi = true)
//@Composable
//fun EmployeeListErrorPreview() {
//    EmployeeList(
//        EmployeeListState(emptyStateText = "Some error message"),
//        onItemClick = {}
//    )
//}