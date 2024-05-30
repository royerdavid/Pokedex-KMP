package royerdavid.pokedex.core.data

import androidx.room.Room
import androidx.room.RoomDatabase

inline fun <reified T : RoomDatabase> getDatabaseBuilder(
    dbFileName: String
): RoomDatabase.Builder<T> {
    val dbFilePath = NSHomeDirectory() + "/" + dbFileName
    return Room.databaseBuilder<T>(
        name = dbFilePath,
        factory = { T::class.instantiateImpl() }
    )
}
