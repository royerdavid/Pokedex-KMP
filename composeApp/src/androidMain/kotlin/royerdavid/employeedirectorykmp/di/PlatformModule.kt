package royerdavid.employeedirectorykmp.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import royerdavid.employeedirectorykmp.features.counter.CounterViewModel
import royerdavid.employeedirectorykmp.features.employees.presentation.EmployeeListViewModel

actual val platformModule = module {
    viewModelOf(::CounterViewModel)
    viewModelOf(::EmployeeListViewModel)
}
