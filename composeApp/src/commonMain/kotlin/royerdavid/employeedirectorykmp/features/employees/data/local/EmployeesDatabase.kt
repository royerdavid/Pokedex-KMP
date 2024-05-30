package royerdavid.employeedirectorykmp.features.employees.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import royerdavid.employeedirectorykmp.features.employees.data.local.entity.EmployeeEntity

const val EMPLOYEES_DATABASE_FILE_NAME = "employees.db"

@Database(
    entities = [EmployeeEntity::class],
    version = 1
)
abstract class EmployeesDatabase : RoomDatabase() {
    abstract val dao: EmployeesDao
}
