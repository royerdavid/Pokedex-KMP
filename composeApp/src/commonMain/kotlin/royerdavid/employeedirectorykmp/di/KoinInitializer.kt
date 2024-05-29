package royerdavid.employeedirectorykmp.di

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import org.koin.compose.currentKoinScope

expect class KoinInitializer {
    fun init()
}

fun appModule() = listOf(
    httpClientModule,
    viewModelModule
)

/**
 * Utility method from Philipp Lackner trainings. To replace when available in Koin library.
 */
@Composable
inline fun <reified T : ViewModel> koinViewModel(): T {
    val scope = currentKoinScope()
    return viewModel {
        scope.get<T>()
    }
}
