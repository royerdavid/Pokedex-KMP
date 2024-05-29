import androidx.compose.ui.window.ComposeUIViewController
import royerdavid.employeedirectorykmp.App
import royerdavid.employeedirectorykmp.di.KoinInitializer

@Suppress("FunctionName")
fun MainViewController() = ComposeUIViewController(
    configure = {
        KoinInitializer().init()
    }
) {
    App()
}
