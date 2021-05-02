package com.example.rworksample00026

import android.widget.TextView
import com.example.rworksample00026.ui.ThirdActivity
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ThirdActivityUnitTest {
    @Test
    fun testActivity() {
        val activity : ThirdActivity = Robolectric.buildActivity(ThirdActivity::class.java).setup().get()
        val text :TextView = activity.findViewById(R.id.textView)
        Assert.assertEquals("勤務開始後も定着サポート！", text.text.toString())
    }
}