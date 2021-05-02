package com.example.rworksample00026

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.rworksample00026.model.entity.DailyReports
import com.example.rworksample00026.model.entity.RequestDocumentsPersonInfo
import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class DailyReportsLocalDataSourceTest {

    lateinit var dailyReportsLocalDataSource: DailyReportsLocalDataSource

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val db = Room.databaseBuilder(context, RworkDatabase::class.java, "DB")
            .allowMainThreadQueries()
            .build()
        dailyReportsLocalDataSource = DailyReportsLocalDataSource(db)
    }

    @Test
    fun insertAll() {
        var list = dailyReportsLocalDataSource.findByName("murata")
        Assertions.assertThat(list).isEmpty()

        val name = "murata"
        dailyReportsLocalDataSource.insertAll(
            DailyReports(1, "村田秀平＿日報報告書2021年4月21日", name, "2021/04/21", "アプリ案作成を進める", "10:00", "15:00", "アプリ案の試作(日報データベースのテストコードの作成)", "アプリ案の試作(日報データベースのテストコードの作成)", "アプリ案の試作をしていました。画面上には出てこない部分なので進捗上は何も進んでいないように見えますが、正常に動作するか確認する工程なので確実に進めていきたいと思います。", "朝食、昼食とれています。", "しっかりとれています。", "","特にありません。", "特にありません。", "","",false),
            DailyReports(2, "村田秀平＿日報報告書2021年4月21日", name, "2021/04/21", "アプリ案作成を進める","10:00", "15:00", "アプリ案の試作(日報データベースのテストコードの作成)","アプリ案の試作(日報データベースのテストコードの作成)", "アプリ案の試作をしていました。画面上には出てこない部分なので進捗上は何も進んでいないように見えますが、正常に動作するか確認する工程なので確実に進めていきたいと思います。", "朝食、昼食とれています。", "しっかりとれています。", "","特にありません。", "特にありません。", "", "",false)
        )

        list = dailyReportsLocalDataSource.findByName("murata")
        Assertions.assertThat(list).hasSize(2)
    }
}