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
    abstract fun reportsDao(): DailyReportsDao
    abstract fun userDao(): UserDao

    companion object {
        fun buildDatabase(context: Context): RworkDatabase {
            return Room.databaseBuilder(
                context,
                RworkDatabase::class.java,
                "rwork.db"
            ).openHelperFactory(SupportFactory(SQLiteDatabase.getBytes("hworldrwork".toCharArray())))
                .allowMainThreadQueries()
                .build()
        }
    }
}