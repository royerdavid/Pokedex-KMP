package royerdavid.employeedirectorykmp.features.employees.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import royerdavid.employeedirectorykmp.features.employees.domain.model.Employee
import royerdavid.employeedirectorykmp.features.employees.domain.model.EmployeeType

@Serializable
data class EmployeeDto(
    @SerialName("biography") val biography: String?,
    @SerialName("email_address") val emailAddress: String,
    @SerialName("employee_type") val employeeType: EmployeeType,
    @SerialName("full_name") val fullName: String,
    @SerialName("phone_number") val phoneNumber: String?,
    @SerialName("photo_url_large") val photoUrlLarge: String?,
    @SerialName("photo_url_small") val photoUrlSmall: String?,
    @SerialName("team") val team: String,
    @SerialName("uuid") val uuid: String
) {
//    fun toEmployeeEntity() = EmployeeEntity(
//        id = uuid,
//        name = fullName,
//        phoneNumber = phoneNumber,
//        email = emailAddress,
//        biography = biography,
//        smallImageUrl = photoUrlSmall,
//        largeImageUrl = photoUrlLarge,
//        team = team,
//        employeeType = employeeType
//    )

    fun toEmployee() = Employee(
        id = uuid,
        name = fullName,
        phoneNumber = phoneNumber,
        email = emailAddress,
        biography = biography,
        smallImageUrl = photoUrlSmall,
        largeImageUrl = photoUrlLarge,
        team = team,
        employeeType = employeeType
    )
}
