package royerdavid.employeedirectorykmp.features.employees.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import royerdavid.employeedirectorykmp.features.employees.domain.model.Employee
import royerdavid.employeedirectorykmp.features.employees.domain.model.EmployeeType

@Entity
data class EmployeeEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val phoneNumber: String? = null,
    val email: String,
    val biography: String? = null,
    val smallImageUrl: String? = null,
    val largeImageUrl: String? = null,
    val team: String,
    val employeeType: EmployeeType
) {
    fun toEmployee() = Employee(
        id = id,
        name = name,
        phoneNumber = phoneNumber,
        email = email,
        biography = biography,
        smallImageUrl = smallImageUrl,
        largeImageUrl = largeImageUrl,
        team = team,
        employeeType = employeeType
    )
}
