package royerdavid.pokedex.core.data

import androidx.room.Room
import androidx.room.RoomDatabase
import java.io.File

inline fun <reified T : RoomDatabase> getDatabaseBuilder(
    dbFileName: String
): RoomDatabase.Builder<T> {
    val dbFile = File(System.getProperty("java.io.tmpdir"), dbFileName)
    return Room.databaseBuilder<T>(
        name = dbFile.absolutePath,
    )
}
