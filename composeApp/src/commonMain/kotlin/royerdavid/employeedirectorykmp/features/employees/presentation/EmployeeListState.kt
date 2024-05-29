package royerdavid.employeedirectorykmp.features.employees.presentation

import royerdavid.employeedirectorykmp.features.employees.domain.model.Employee

data class EmployeeListState(
    val emptyStateText: String = "",
    val isLoading: Boolean = false,
    val employeeList: List<Employee> = emptyList()
)
