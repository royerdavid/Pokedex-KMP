import androidx.compose.ui.window.ComposeUIViewController
import royerdavid.pokedex.App
import royerdavid.pokedex.KoinInitializer

@Suppress("FunctionName")
fun MainViewController() = ComposeUIViewController(
    configure = {
        KoinInitializer().init()
    }
) {
    App()
}
