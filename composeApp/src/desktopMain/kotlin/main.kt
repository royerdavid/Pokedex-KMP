import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import royerdavid.pokedex.APP_NAME
import royerdavid.pokedex.App
import royerdavid.pokedex.KoinInitializer

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = APP_NAME,
    ) {
        KoinInitializer().init()
        App()
    }
}
