package com.example.rworksample00026

import android.widget.Button
import com.example.rworksample00026.ui.MainActivity
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf

@RunWith(RobolectricTestRunner::class)
class MainActivityUnitTest {
    @Test
    fun testActivity() {
        val activity: MainActivity = Robolectric.buildActivity(MainActivity::class.java).setup().get()
        val shadowActivity = shadowOf(activity)
        val intent = shadowActivity.peekNextStartedActivity()
        //val actual = intent.getStringExtra("stmt")
        //Assert.assertEquals("資料請求", actual)
        val button1 = activity.findViewById<Button>(R.id.request_documents_btn)
        val button2 = activity.findViewById<Button>(R.id.experience_btn)
        val button3 = activity.findViewById<Button>(R.id.beginner_btn)
        val button4 = activity.findViewById<Button>(R.id.attendant_btn)
        val button5 = activity.findViewById<Button>(R.id.staff_btn)
        button1.performClick()
        button2.performClick()
        button3.performClick()
        button4.performClick()
        button5.performClick()
    }
}