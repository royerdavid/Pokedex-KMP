package royerdavid.pokedex.core.ui.component

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

/**
 * Helper to handle snackbar messages.
 *
 * Based on Google's recommendations:
 *   - [Snackbar basics](https://developer.android.com/develop/ui/compose/components/snackbar#basic_example)
 *   - [Consuming events ](https://developer.android.com/topic/architecture/ui-layer/events?authuser=1#consuming-trigger-updates)
 */
@Composable
fun handleSnackbarMessages(
    snackbarHostState: SnackbarHostState,
    userMessages: List<String>,
    onUserMessagesClear: () -> Unit
) {
    val scope = rememberCoroutineScope()

    scope.launch {
        for (message in userMessages) {
            snackbarHostState.showSnackbar(message)
        }
    }

    onUserMessagesClear.invoke()
}
