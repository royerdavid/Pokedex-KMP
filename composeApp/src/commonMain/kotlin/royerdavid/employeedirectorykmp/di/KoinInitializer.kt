package royerdavid.employeedirectorykmp.di

import networkModule
import royerdavid.employeedirectorykmp.features.employees.di.employeesModule

expect class KoinInitializer {
    fun init()
}

fun moduleList() = listOf(
    networkModule,
    employeesModule,
    platformModule
)
