package com.example.rworksample00026

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.rworksample00026.model.entity.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
//import org.junit.Assert.assertThat as assertThat

@RunWith(RobolectricTestRunner::class)
class UserLocalDataSourceTest {
    lateinit var userLocalDataSource: UserLocalDataSource

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val db = Room.databaseBuilder(context, RworkDatabase::class.java, "DB")
            .allowMainThreadQueries()
            .build()
        userLocalDataSource = UserLocalDataSource(db)
    }

    @Test
    fun insertAll() {
        var list = userLocalDataSource.findByName("murata")
        assertThat(list).isEmpty()

        val name = "murata"
        userLocalDataSource.insertAll(
            User(1, name, "smurata16@gmail.com"),
            User(2, name, "smurata16@gmail.com")
        )

        list = userLocalDataSource.findByName("murata")
        assertThat(list).hasSize(2)
    }
}