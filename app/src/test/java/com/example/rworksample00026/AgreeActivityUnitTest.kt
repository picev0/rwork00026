package com.example.rworksample00026

import android.content.Intent
import android.os.Looper.getMainLooper
import android.widget.Button
import android.widget.TextView
import com.example.rworksample00026.ui.AgreeActivity
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment.application
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.LooperMode

@RunWith(RobolectricTestRunner::class)
@LooperMode(LooperMode.Mode.LEGACY)
class AgreeActivityUnitTest {
    @Test
    fun testActivity() {
        val intent = Intent(application.applicationContext, AgreeActivity::class.java)
        intent.putExtra("stmt", "資料請求")
        //https://living-sun.com/ja/robolectric/745758-robolectric-testing-an-activity-expecting-extras-version-2x-robolectric.html
        /*
        **withIntent(intent) メソッドは非推奨です。ドキュメントの意図に従って、代わりにコンストラクターを介して渡す必要があります。
         */
        val activity : AgreeActivity = Robolectric.buildActivity(AgreeActivity::class.java, intent).setup().get()
//        val shadowActivity = shadowOf(activity)
//        val intent = shadowActivity.peekNextStartedActivity()
        //val intent = Intent(application.applicationContext, AgreeActivity::class.java)
        val text1 = activity.findViewById<TextView>(R.id.privacystmt)
        val text2 = activity.findViewById<TextView>(R.id.privacytheme)
        val button1 = activity.findViewById<Button>(R.id.nextPageBtn)
        val button2 = activity.findViewById<Button>(R.id.gotobrowse)
        Assert.assertEquals("入力された個人情報は、プライバシーポリシーに基づき取り扱われます。\nプライバシーポリシーをご確認いただき、同意の上で「次へ」ボタンをタップしてください。", text1.text.toString())
        Assert.assertEquals("プライバシーポリシーの同意について", text2.text.toString())
        button1.performClick()
        button2.performClick()
    }
}