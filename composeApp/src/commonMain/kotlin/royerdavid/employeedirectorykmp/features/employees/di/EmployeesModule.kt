package royerdavid.employeedirectorykmp.features.employees.di

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.dsl.module
import royerdavid.employeedirectorykmp.features.employees.data.EmployeesRepositoryImpl
import royerdavid.employeedirectorykmp.features.employees.data.local.EmployeesDatabase
import royerdavid.employeedirectorykmp.features.employees.data.remote.EmployeesApi
import royerdavid.employeedirectorykmp.features.employees.domain.EmployeesRepository


val employeesModule = module {

    single<EmployeesRepository> {
        EmployeesRepositoryImpl(get(), get())
    }

    single {
        EmployeesApi(get())
    }

    single {
        getEmployeesDatabase(get())
    }

    single {
        get<EmployeesDatabase>().dao
    }
}

private fun getEmployeesDatabase(
    builder: RoomDatabase.Builder<EmployeesDatabase>
): EmployeesDatabase {
    return builder
        .fallbackToDestructiveMigrationOnDowngrade(true)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
