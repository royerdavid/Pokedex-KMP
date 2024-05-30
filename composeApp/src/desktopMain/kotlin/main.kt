import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import royerdavid.pokedex.RootScreen
import royerdavid.pokedex.di.KoinInitializer

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Pokedex", // TODO
    ) {
        KoinInitializer().init()
        RootScreen()
    }
}