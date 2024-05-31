package royerdavid.pokedex.core.ui.component

import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun ApplyStatusBarTheme(darkTheme: Boolean)

@Composable
expect fun DesktopVerticalScrollbar(
    modifier: Modifier = Modifier,
    lazyGridState: LazyGridState
)