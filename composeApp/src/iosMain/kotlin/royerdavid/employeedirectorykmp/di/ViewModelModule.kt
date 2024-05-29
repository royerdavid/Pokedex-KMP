package royerdavid.employeedirectorykmp.di

import royerdavid.employeedirectorykmp.MainViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val viewModelModule = module {
    singleOf(::MainViewModel)
}
