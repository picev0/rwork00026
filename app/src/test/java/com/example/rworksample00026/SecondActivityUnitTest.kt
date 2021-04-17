package com.example.rworksample00026

import android.widget.TextView
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class SecondActivityUnitTest {
    @Test
    fun testActivity() {
        val activity: SecondActivity = Robolectric.buildActivity(SecondActivity::class.java).setup().get()
        val text = activity.findViewById<TextView>(R.id.textView)
        Assert.assertEquals("ユニークなプログラム", text.text.toString() )
    }
}