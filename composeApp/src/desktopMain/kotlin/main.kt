import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.koin.core.Koin
import org.koin.core.context.startKoin

//lateinit var koin: Koin

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "EmployeeDirectoryKmp",
    ) {

        //koin = initKoin().koin

        //KoinInitializer().init()
        startKoin {
            modules(appModule, viewModelModule)
        }

        App()
    }
}