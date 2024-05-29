
package royerdavid.employeedirectorykmp.features.employees.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun EmployeeListScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        ListDetailLayout(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
private fun ListDetailLayout(
    modifier: Modifier = Modifier
) {
    //val navigator = rememberListDetailPaneScaffoldNavigator<Any>()

//    NavigableListDetailPaneScaffold(
//        modifier = modifier,
//        navigator = navigator,
//        listPane = { EmployeeListPane(navigator) },
//        detailPane = { AnimatedPane { EmployeeDetailPane(navigator) } },
//        defaultBackBehavior = BackNavigationBehavior.PopUntilCurrentDestinationChange
//    )

    EmployeeScreen()
}
