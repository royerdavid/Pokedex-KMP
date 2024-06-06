package royerdavid.pokedex.core.ui.component

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
fun handleSnackbarMessages(
    snackbarHostState: SnackbarHostState,
    userMessages: List<String>,
    onDismiss: () -> Unit
) {
    val message = userMessages.firstOrNull()
    LaunchedEffect(message) {
        if (message != null) {
            snackbarHostState.showSnackbar(message)
            onDismiss.invoke()
        }
    }
}