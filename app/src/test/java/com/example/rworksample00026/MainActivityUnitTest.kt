package com.example.rworksample00026

import android.widget.Button
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MainActivityUnitTest {
    @Test
    fun testActivity() {
        val activity: MainActivity = Robolectric.buildActivity(MainActivity::class.java).setup().get()
        val button1 = activity.findViewById<Button>(R.id.request_documents_btn)
        val button2 = activity.findViewById<Button>(R.id.)
        button1.performClick()
    }
}