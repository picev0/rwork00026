package com.example.rworksample00026

import android.widget.TextView
import com.example.rworksample00026.ui.FirstActivity
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class FirstActivityUnitTest {
    @Test
    fun testActivity() {
        val activity: FirstActivity = Robolectric.buildActivity(FirstActivity::class.java).setup().get()
        val text = activity.findViewById<TextView>(R.id.textView).text
        Assert.assertEquals("あなた専用の支援プラン", text)
    }
}