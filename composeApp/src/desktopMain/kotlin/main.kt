import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import royerdavid.employeedirectorykmp.App
import royerdavid.employeedirectorykmp.di.KoinInitializer

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "EmployeeDirectoryKmp",
    ) {
        KoinInitializer().init()
        App()
    }
}