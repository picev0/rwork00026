package com.example.rworksample00026

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rworksample00026.model.dao.*
import com.example.rworksample00026.model.entity.*
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory

@Database(entities = arrayOf(ExperiencePersonInfo::class, DailyReports::class, RequestDocumentsPersonInfo::class, User::class), version = 2, exportSchema = false)
abstract class RworkDatabase : RoomDatabase() {
    abstract fun experiencePersonInfoDao(): ExperiencePersonInfoDao
    abstract fun requestDocumentsPersonInfoDao(): RequestDocumentsPersonInfoDao
    abstract fun dailyReportsDao(): DailyReportsDao
    abstract fun userDao(): UserDao

    companion object {

        var TEST_MODE = false
        private val databaseName = "database_name"
        private var db: RworkDatabase? = null


        fun buildDatabase(context: Context): RworkDatabase {

            if (db == null) {
                if (TEST_MODE) {
                    db = Room.inMemoryDatabaseBuilder(context, RworkDatabase::class.java).openHelperFactory(SupportFactory(SQLiteDatabase.getBytes("test".toCharArray()))).allowMainThreadQueries().build()

                }
                else {
                    db = Room.databaseBuilder(context, RworkDatabase::class.java, "rwork.db").openHelperFactory(SupportFactory(SQLiteDatabase.getBytes(BuildConfig.PASSWORD.toCharArray()))).allowMainThreadQueries().build()
                }
            }

            return db!!
        }

        private fun close(){
            db?.close()
        }
    }
}