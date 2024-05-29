import androidx.compose.ui.window.ComposeUIViewController
import royerdavid.employeedirectorykmp.RootScreen
import royerdavid.employeedirectorykmp.di.KoinInitializer

@Suppress("FunctionName")
fun MainViewController() = ComposeUIViewController(
    configure = {
        KoinInitializer().init()
    }
) {
    RootScreen()
}
