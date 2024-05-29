package royerdavid.employeedirectorykmp.features.employees.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import royerdavid.employeedirectorykmp.features.employees.data.remote.dto.EmployeeDto

@Serializable
data class EmployeesRootDto(
    @SerialName("employees") val employees: List<EmployeeDto>
)
