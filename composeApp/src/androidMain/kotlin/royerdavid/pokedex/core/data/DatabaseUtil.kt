@file:Suppress("SameParameterValue")

package royerdavid.pokedex.core.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

inline fun <reified T : RoomDatabase> getDatabaseBuilder(
    ctx: Context,
    dbFileName: String
): RoomDatabase.Builder<T> {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath(dbFileName)
    return Room.databaseBuilder<T>(
        context = appContext,
        name = dbFile.absolutePath
    )
}
