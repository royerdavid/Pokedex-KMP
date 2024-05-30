package royerdavid.employeedirectorykmp.di

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import royerdavid.employeedirectorykmp.core.data.getDatabaseBuilder
import royerdavid.employeedirectorykmp.features.employees.data.local.EMPLOYEES_DATABASE_FILE_NAME
import royerdavid.employeedirectorykmp.features.employees.data.local.EmployeesDatabase
import royerdavid.employeedirectorykmp.features.employees.presentation.EmployeeListViewModel

actual val platformModule = module {
    viewModelOf(::EmployeeListViewModel)

    single {
        getDatabaseBuilder<EmployeesDatabase>(androidContext(), EMPLOYEES_DATABASE_FILE_NAME)
    }
}
