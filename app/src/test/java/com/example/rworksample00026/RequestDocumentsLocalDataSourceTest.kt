package com.example.rworksample00026

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.rworksample00026.model.entity.RequestDocumentsPersonInfo
import com.example.rworksample00026.model.entity.User
import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class RequestDocumentsLocalDataSourceTest {

    lateinit var requestDocumentsLocalDataSource: RequestDocumentsLocalDataSource

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val db = Room.databaseBuilder(context, RworkDatabase::class.java, "DB")
            .allowMainThreadQueries()
            .build()
        requestDocumentsLocalDataSource = RequestDocumentsLocalDataSource(db)
    }

    @Test
    fun insertAll() {
        var list = requestDocumentsLocalDataSource.findByName("murata")
        Assertions.assertThat(list).isEmpty()

        val name = "murata"
        requestDocumentsLocalDataSource.insertAll(
            RequestDocumentsPersonInfo(1, name, "むらた", "1987/07/20", "xxxxxxx", "xx県", "xx市", "x区", "xxx-xxx-xxxx", "smurata16@gmail.com", "申請中", "送付を希望する", ""),
            RequestDocumentsPersonInfo(2, name, "むらた", "1987/07/20", "xxxxxxx","xx県", "xx市", "x区","xxx-xxx-xxxx", "smurata16@gmail.com", "あり", "送付を希望しない", "")
        )

        list = requestDocumentsLocalDataSource.findByName("murata")
        Assertions.assertThat(list).hasSize(2)
    }
}