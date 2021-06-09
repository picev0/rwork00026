package com.example.rworksample00026.ui.dailyreports

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.rworksample00026.BuildConfig
import com.example.rworksample00026.databinding.ActivityDailyReportsSendConfirmBinding
import com.example.rworksample00026.ui.UserViewModel
import com.example.rworksample00026.ui.util.ScopedAppActivity
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.coroutines.awaitStringResponseResult
import com.github.kittinunf.fuel.httpPost
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.StringBuilder
import java.util.*
import com.github.kittinunf.result.Result
import kotlinx.coroutines.runBlocking
import java.text.SimpleDateFormat

class DailyReportsSendConfirmActivity : ScopedAppActivity() {

    private lateinit var binding: ActivityDailyReportsSendConfirmBinding
    private val viewModel: DailyReportsViewModel by viewModels()
    private val userViewModel : UserViewModel by viewModels()
    private var flag = false
    private var title = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailyReportsSendConfirmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        launch (Dispatchers.IO){
            val data = viewModel.reportsData
            val count = viewModel.reportsData.count() - 1
            launch(Dispatchers.Main) {
                binding.title.text = data.map{it.title}[count].toString()
                binding.date.text = data.map{it.date}[count].toString()
                binding.weeklyGoal.text = data.map{it.weeklyGoal}[count].toString()
                binding.commutingTimeBefore.text = data.map {it.commutingTimeBefore}[count].toString()
                binding.commutingTimeAfter.text = data.map{it.commutingTimeAfter}[count].toString()
                binding.participationPrograms.text = data.map{it.participationProgram}[count].toString()
                binding.detailsOfEfforts.text = data.map{it.detailsOfEfforts}[count].toString()
                binding.impressions.text = data.map{it.impressions}[count].toString()
                binding.meal.text = data.map{it.meal}[count].toString()
                binding.sleep.text = data.map{it.sleep}[count].toString()
                binding.motion.text = data.map{it.motion}[count].toString()
                binding.tirednessAndStress.text = data.map{it.tirednessAndStress}[count].toString()
                binding.remarks.text = data.map{it.remarks}[count].toString()
                binding.lookingBack.text = data.map{it.lookingBack}[count].toString()
                binding.nextWeekChallengeAndGoals.text = data.map{it.nextWeeksChallengeAndGoals}[count].toString()

            }
        }

        val body = StringBuilder()
        //title = StringBuilder()
        launch (Dispatchers.IO){
            val data = viewModel.reportsData
            val count = viewModel.reportsData.count() - 1
            launch(Dispatchers.Main) {
                //body.append("件名&#058;"+ data.map{it.title}[0].toString())
                //body.append("<br>")
                title.append( data.map{it.title}[count].toString())
                body.append("<br>")
                body.append("日付&#058;"+ data.map{it.date}[count].toString())
                body.append("<br>")
                body.append("週間目標&#058;"+ data.map{it.weeklyGoal}[count].toString())
                body.append("<br>")
                body.append("&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;")
                body.append("<br>")
                body.append("本日の報告内容&#12304;作業面&#12305;")
                body.append("<br>")
                body.append("&#9312;通所時間&#058;" + data.map {it.commutingTimeBefore}[count].toString() + "～" + data.map{it.commutingTimeAfter}[count].toString())
                body.append("<br>")
                body.append("&#9313;参加プログラム&#058;"+ data.map{it.participationProgram}[count].toString())
                body.append("<br>")
                body.append("&#9314;取り組み内容&#058;" + data.map{it.detailsOfEfforts}[count].toString())
                body.append("<br>")
                body.append("&#9315;所感：" + data.map{it.impressions}[count].toString())
                body.append("<br>")
                body.append("&#12304;生活面&#12305;")
                body.append("<br>")
                body.append("&#9312;食事&#058;" + data.map{it.meal}[count].toString())
                body.append("<br>")
                body.append("&#9313;睡眠&#058;" + data.map{it.sleep}[count].toString())
                body.append("<br>")
                body.append("&#9314;運動&#058;" + data.map{it.motion}[count].toString())
                body.append("<br>")
                body.append("&#9315;疲れ・ストレス&#058;" + data.map{it.tirednessAndStress}[count].toString())
                body.append("<br>")
                body.append("&#12304;備考&#12305;作業面・生活面以外の報告事項&#058;" + data.map{it.remarks}[count].toString())
                body.append("<br>")
                body.append("&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;")
                body.append("<br>")
                body.append("&#12304;一週間の総括&#12305;※その週の最後の通所日のみ入力")
                body.append("<br>")
                body.append("&#40;１&#41;振り返り&#058;" + data.map{it.lookingBack}[count].toString())
                body.append("<br>")
                body.append("&#40;２&#41;次週の課題・目標&#058;" + data.map { it.nextWeeksChallengeAndGoals }[count].toString() )
                body.append("<br>")
                body.append("&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;&#045;")

            }
        }
        body.toString().trimIndent()

        binding.submit.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                //sendBySendGrid()
                mailSend(body)
                Log.d("[flag]", flag.toString())
                //Log.d("[flag]",binding.flag.text.toString())
                if (flag) {
                    val intent = Intent(this@DailyReportsSendConfirmActivity, DailyReportsSendResultActivity::class.java)
                    startActivity(intent)
                } else if(flag == false) {
                    //Toast.makeText(this@RequestDocumentsConfirmActivity, "メールが送信できませんでした。", Toast.LENGTH_LONG)
                    Log.d("[mailerror]", "XXX")
                } else {
                    Log.d("[mailerror]", "XXX")
                }
            }
        })

        binding.backBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@DailyReportsSendConfirmActivity, DailyReportsConfirmActivity::class.java)
                startActivity(intent)
            }
        })
    }

    fun mailSend(body :StringBuilder) {

        var to = "fuflv4659@gmail.com"
        var from = "hakata.r.murata@gmail.com"
        if(userViewModel.emailList.count() >= 1){
            from = userViewModel.emailList[0].gmail
            println("$from")
        }
        var fromName = "SenderKotlin"
        var date = SimpleDateFormat("yyyy年MM月dd日").format(Date())
        if(userViewModel.emailList.count() >= 1){
            fromName = userViewModel.emailList[0].name
            println("$fromName")
        }


        var content = """
        {
            "personalizations": [
                {
                    "to": [
                        {
                            "email": "$to" 
                        }
                    ]
                }
            ],
            "from": {
                "email": "$from",
                "name": "$fromName"
            },
            "subject": "$fromName　日報報告書＿$date",
            "content": [
                {
                    "type": "text/plain",
                    "value": "Kotlinから送った"
                },
                {
                    "type": "text/html",
                    "value": "<html><body>$body</body></html>"
                }
            ]
        }
        """

        runBlocking {
            FuelManager.instance.baseHeaders = mapOf("Content-Type" to "application/json", "Authorization" to "Bearer ${BuildConfig.API_KEY}")
            val (req, res, result) = "https://api.sendgrid.com/v3/mail/send".httpPost().body(content).awaitStringResponseResult()
            //https://github.com/kittinunf/fuel/tree/master/fuel-coroutines
            when (result) {
                is Result.Failure -> {
                    val ex = result.getException()
                    println(ex)
                    flag = false
                }
                is Result.Success -> {
                    val data = result.get()
                    println(data)
                    when (res.statusCode) {
                        202 -> flag = true
                        400, 401, 413 -> flag = false
                        else -> flag = false
                    }

                }
            }
            println(req)
            println(res)
            println(result)


        }


    }

}