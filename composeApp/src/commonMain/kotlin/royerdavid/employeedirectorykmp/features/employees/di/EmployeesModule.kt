package royerdavid.employeedirectorykmp.features.employees.di

import org.koin.dsl.module
import royerdavid.employeedirectorykmp.features.employees.data.EmployeesRepositoryImpl
import royerdavid.employeedirectorykmp.features.employees.data.remote.EmployeesApi
import royerdavid.employeedirectorykmp.features.employees.domain.EmployeesRepository

val employeesModule = module {
    //   viewModelOf(::EmployeeListViewModel)

//    single {
//        get<EmployeesDatabase>().dao
//    }

    single {
        EmployeesApi(get())
    }

    single<EmployeesRepository> {
        EmployeesRepositoryImpl(get())
    }

//    single {
//        Room.databaseBuilder(androidApplication(), EmployeesDatabase::class.java, "employees.db")
//            .openHelperFactory(FrameworkSQLiteOpenHelperFactory())
//            .build()
//    }
}
