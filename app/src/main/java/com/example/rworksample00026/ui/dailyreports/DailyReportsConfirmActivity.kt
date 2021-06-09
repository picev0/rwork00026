package com.example.rworksample00026.ui.dailyreports

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityDailyReportsConfirmBinding
import com.example.rworksample00026.ui.util.ScopedAppActivity
import java.lang.StringBuilder

class DailyReportsConfirmActivity : ScopedAppActivity() {

    private lateinit var binding: ActivityDailyReportsConfirmBinding
    private val viewModel: DailyReportsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailyReportsConfirmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = viewModel.reportsData
        val str = StringBuilder()
        for (i in 0 until list.count()) {
            str.append("件名：　")
            str.append(list.map{it.title}[i].toString())
            str.append("\n")
            str.append("日付：　")
            str.append(list.map{it.date}[i].toString())
            str.append("\n")
            str.append("週間目標：　")
            str.append(list.map{it.weeklyGoal}[i].toString())
            str.append("\n")
            str.append("-----------------------")
            str.append("\n")
            str.append("本日の報告内容【作業面】")
            str.append("\n")
            str.append("通所時間：　")
            str.append(list.map{it.commutingTimeBefore}[i].toString())
            str.append("～")
            str.append(list.map{it.commutingTimeAfter}[i].toString())
            str.append("\n")
            str.append("参加プログラム：　")
            str.append(list.map{it.participationProgram}[i].toString())
            str.append("\n")
            str.append("取り組み内容：　")
            str.append(list.map{it.detailsOfEfforts}[i].toString())
            str.append("\n")
            str.append("所感：　")
            str.append(list.map{it.impressions}[i].toString())
            str.append("\n")
            str.append("【生活面】")
            str.append("①食事：　")
            str.append(list.map{it.meal}[i].toString())
            str.append("\n")
            str.append("②睡眠：　")
            str.append(list.map{it.sleep}[i].toString())
            str.append("\n")
            str.append("③運動：　")
            str.append(list.map{it.motion}[i].toString())
            str.append("\n")
            str.append("④疲れ・ストレス：　")
            str.append(list.map{it.tirednessAndStress}[i].toString())
            str.append("\n")
            str.append("【備考】作業面・生活面以外の報告事項")
            str.append(list.map{it.remarks}[i].toString())
            str.append("\n")
            str.append("----------------------")
            str.append("\n")
            str.append("【一週間の総括】※その週の最後の通所日のみ入力")
            str.append("\n")
            str.append("⑴振り返り：　")
            str.append(list.map{it.lookingBack}[i].toString())
            str.append("\n")
            str.append("⑵次週の課題・目標：　")
            str.append(list.map{it.nextWeeksChallengeAndGoals}[i].toString())
            str.append("\n")
        }
        binding.textView.text = str.toString()

        binding.submitConfirm.setOnClickListener (object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@DailyReportsConfirmActivity, DailyReportsSendConfirmActivity::class.java)
                startActivity(intent)
            }
        })

        binding.fixBtn.setOnClickListener (object :View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@DailyReportsConfirmActivity, DailyReportsFixActivity::class.java)
                startActivity(intent)
            }
        })
    }
}