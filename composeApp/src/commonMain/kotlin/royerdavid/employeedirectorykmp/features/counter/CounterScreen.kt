package royerdavid.employeedirectorykmp.features.counter

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import royerdavid.employeedirectorykmp.core.ui.theme.EmployeeDirectoryTheme
import royerdavid.employeedirectorykmp.di.koinViewModel

@Composable
@Preview
fun CounterScreen() {
    EmployeeDirectoryTheme {
        KoinContext {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "screenA"
            ) {
                composable("screenA") {
                    val viewModel = koinViewModel<CounterViewModel>()
                    val timer by viewModel.timer.collectAsState()
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = timer.toString()
                        )
                    }
                }
            }
        }
    }
}
