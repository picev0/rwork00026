package com.example.rworksample00026

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.rworksample00026.model.dao.UserDao
import com.example.rworksample00026.model.entity.User
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.IOException

@RunWith(RobolectricTestRunner::class)
class SimpleEntityReadWriteTest {
    private lateinit var userDao: UserDao
    private lateinit var db: RworkDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, RworkDatabase::class.java
        ).allowMainThreadQueries().build()

        userDao = db.userDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() {
        //val user = userDao.insertUser()
    }
}