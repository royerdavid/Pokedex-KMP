import androidx.compose.ui.window.ComposeUIViewController

@Suppress("FunctionName")
fun MainViewController() = ComposeUIViewController(
    configure = {
        KoinInitializer().init()
    }
) {
    App()
}
