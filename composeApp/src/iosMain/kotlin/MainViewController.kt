import androidx.compose.ui.window.ComposeUIViewController
import royerdavid.pokedex.RootScreen
import royerdavid.pokedex.di.KoinInitializer

@Suppress("FunctionName")
fun MainViewController() = ComposeUIViewController(
    configure = {
        KoinInitializer().init()
    }
) {
    RootScreen()
}
