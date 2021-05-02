package com.example.rworksample00026

import android.app.Application
import android.content.Context
import androidx.room.RoomDatabase
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.rworksample00026.model.dao.UserDao
import com.example.rworksample00026.ui.UserViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
//import org.assertj.core.api.Assertions.assertThat
//import org.mockito.Mockito
//import org.mockito.Mockito.mock
//import net.sqlcipher.database.SQLiteDatabase
//import org.robolectric.RobolectricTestRunner

@RunWith(AndroidJUnit4::class)
class UserViewModelUnitTest {

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        var viewModel = UserViewModel(context as Application)
    }




    @Test
    fun init() {

        //assertThat(viewModel.)
    }
        // メソッドの呼び出し


        //System.loadLibrary("libsqlcipher")
        //viewModel.insert("murata", "smurata16@gmail.com")



}