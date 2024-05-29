package royerdavid.employeedirectorykmp.features.employees.domain.use_case

import royerdavid.employeedirectorykmp.features.employees.domain.EmployeesRepository

class GetEmployees(
    private val repository: EmployeesRepository
) {
//
//    operator fun invoke(): Result<List<Employee>> {
//        return repository.getEmployees()
//    }
}