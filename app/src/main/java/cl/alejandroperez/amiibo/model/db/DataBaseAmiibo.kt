package cl.alejandroperez.amiibo.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = [EntityAmiibo::class], version = 1)
abstract class DataBaseAmiibo : RoomDatabase(){

    abstract fun getDaoAmiibo(): DaoAmiibo

    companion object {

        @Volatile
        private var INSTANCE: DataBaseAmiibo? = null

        fun getDatabase(context: Context): DataBaseAmiibo {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBaseAmiibo::class.java,
                    "heroe_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
