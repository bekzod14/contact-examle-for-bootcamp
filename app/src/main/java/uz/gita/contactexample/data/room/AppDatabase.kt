package uz.gita.contactexample.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.gita.contactexample.data.model.ContactData

@Database(
    entities = [ContactData::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private lateinit var db: AppDatabase

        fun init(context: Context) {
            if (!Companion::db.isInitialized) {
                db = Room.databaseBuilder(context, AppDatabase::class.java, "contactDatabase")
                    .allowMainThreadQueries()
                    .build()
            }
        }

        fun getDatabse(): AppDatabase {
            return db
        }
    }

    abstract fun getContactDao(): ContactDao

}