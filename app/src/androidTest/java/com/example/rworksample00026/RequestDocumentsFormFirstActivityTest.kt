package com.example.rworksample00026

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.activity.viewModels
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.rworksample00026.model.dao.RequestDocumentsPersonInfoDao
import com.example.rworksample00026.model.entity.RequestDocumentsPersonInfo
import com.example.rworksample00026.ui.requestdocuments.RequestDocumentsFormFirstActivity
import com.example.rworksample00026.ui.requestdocuments.RequestDocumentsViewModel
import org.junit.*
import org.junit.Assert.assertEquals
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RequestDocumentsFormFirstActivityTest {

    private lateinit var viewModel: RequestDocumentsViewModel
    private lateinit var requestDocumentsDao: RequestDocumentsPersonInfoDao
    //@get:Rule
    //val activityRule = ActivityTestRule(RequestDocumentsFormFirstActivity::class.java, false, false)

    //@get: Rule
    //val activityRule = ActivityTestRule<RequestDocumentsFormFirstActivity>(RequestDocumentsFormFirstActivity::class.java)
    //private lateinit var appDatabase: RworkDatabase

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        //context.deleteDatabase("rwork.db")
        //val viewModel = RequestDocumentsViewModel(context as Application)
        //appDatabase = mockk()
        //var viewModel = RequestDocumentsViewModel(context as Application)
        //activityRule.launchActivity(null)
        RworkDatabase.TEST_MODE = true
        val db = RworkDatabase.buildDatabase(InstrumentationRegistry.getInstrumentation().context)
        requestDocumentsDao = db.requestDocumentsPersonInfoDao()

        //viewModel = RequestDocumentsViewModel(context as Application)
    }

    @After
    fun tearDown() {
        //activityRule.finishActivity()
        //val context = ApplicationProvider.getApplicationContext<Context>()
        //context.deleteDatabase("rwork.db")
    }



    @Test
    fun test() {
        //https://qiita.com/beyondseeker/items/eed130f3baf4f1e33177
        //https://developer.android.com/guide/components/activities/testing?hl=ja
        // launchActivity???????????????????????????unittest?????????????????????
        /*
        **val scenario = launchActivity<RequestDocumentsFormFirstActivity>()
        //val myDao = mockk<RequestDocumentsPersonInfoDao>()
        //every { appDatabase.requestDocumentsPersonInfoDao() }
        **scenario.onActivity { activity ->
        **    Log.e("RequestDocumentsFormFirstActivity",
        **        "activity.javaClass.simpleName = ${activity.javaClass.simpleName}")
        *///}
        val data = RequestDocumentsPersonInfo(1, "??????", "?????????", "xxxx/xx/xx", "xxxxxxx", "xx???", "xx???", "x???", "xxx-xxx-xxxx", "smurata16@gmail.com", "?????????", "?????????????????????", "")
        requestDocumentsDao.saveRequestDocumentsPersonInfo(data)
        //viewModel.insert("??????","?????????","xxxx/xx/xx", "smurata16@gmail.com","xxx-xxxx-xxxx")
        //viewModel.updateZipStr("")
        //viewModel.updatePrefecture("xx???")
        //viewModel.updateCity("xx???")
        //viewModel.updateAddressMod("x???")
        //viewModel.updateDisableCertificate("?????????")
        //viewModel.updateSendingMaterials("?????????????????????")
        val personDataRecord = requestDocumentsDao.loadAllRequestDocumentsPersonInfo().first()
        assertEquals(personDataRecord.name, data.name)
        





    }


}

