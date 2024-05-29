import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import royerdavid.employeedirectorykmp.AppScreen
import royerdavid.employeedirectorykmp.di.KoinInitializer

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "EmployeeDirectoryKmp",
    ) {
        KoinInitializer().init()
        AppScreen()
    }
}