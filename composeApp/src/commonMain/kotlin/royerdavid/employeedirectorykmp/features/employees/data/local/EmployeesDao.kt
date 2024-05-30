package royerdavid.employeedirectorykmp.features.employees.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import royerdavid.employeedirectorykmp.features.employees.data.local.entity.EmployeeEntity

@Dao
interface EmployeesDao {
    @Query("SELECT * FROM employeeentity")
    suspend fun getAll(): List<EmployeeEntity>

    @Query("SELECT * FROM employeeentity WHERE id=:id")
    suspend fun getById(id: String): EmployeeEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(employeeEntityList: List<EmployeeEntity>)
}
