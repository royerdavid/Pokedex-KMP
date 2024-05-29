package royerdavid.employeedirectorykmp.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import royerdavid.employeedirectorykmp.features.counter.CounterViewModel
import royerdavid.employeedirectorykmp.features.employees.presentation.EmployeeListViewModel

actual val platformModule = module {
    singleOf(::CounterViewModel)
    singleOf(::EmployeeListViewModel)
}
