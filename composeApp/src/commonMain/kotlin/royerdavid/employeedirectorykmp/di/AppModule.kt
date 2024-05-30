package royerdavid.employeedirectorykmp.di

import commonModule
import royerdavid.employeedirectorykmp.features.employees.di.employeesModule

fun appModule() = listOf(
    commonModule,
    employeesModule,
    platformModule
)
