import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import royerdavid.pokedex.App
import royerdavid.pokedex.di.KoinInitializer

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Pokedex",
    ) {
        KoinInitializer().init()
        App()
    }
}