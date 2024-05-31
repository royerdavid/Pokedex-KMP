package royerdavid.pokedex.core.ui.component

import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
actual fun ApplyStatusBarTheme(darkTheme: Boolean) {
}

@Composable
actual fun DesktopVerticalScrollbar(
    modifier: Modifier,
    lazyGridState: LazyGridState
) {
    VerticalScrollbar(
        modifier = modifier,
        adapter = rememberScrollbarAdapter(
            scrollState = lazyGridState
        )
    )
}
