package royerdavid.employeedirectorykmp.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import royerdavid.employeedirectorykmp.core.data.getDatabaseBuilder
import royerdavid.employeedirectorykmp.features.employees.data.local.EMPLOYEES_DATABASE_FILE_NAME
import royerdavid.employeedirectorykmp.features.employees.data.local.EmployeesDatabase
import royerdavid.employeedirectorykmp.features.employees.presentation.EmployeeListViewModel

actual val platformModule = module {
    singleOf(::EmployeeListViewModel)

    single {
        getDatabaseBuilder<EmployeesDatabase>(EMPLOYEES_DATABASE_FILE_NAME)
    }
}
