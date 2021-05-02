package com.example.rworksample00026.ui.dailyreports

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityDailyReportsSendConfirmBinding
import com.example.rworksample00026.ui.UserViewModel
import com.example.rworksample00026.ui.requestdocuments.RequestDocumentsConfirmActivity
import com.example.rworksample00026.ui.requestdocuments.RequestDocumentsSendResultActivity
import com.example.rworksample00026.ui.util.ScopedAppActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.StringBuilder
import java.util.*
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeBodyPart
import javax.mail.internet.MimeMessage
import javax.mail.internet.MimeMultipart

class DailyReportsSendConfirmActivity : ScopedAppActivity() {

    private lateinit var binding: ActivityDailyReportsSendConfirmBinding
    private val viewModel: DailyReportsViewModel by viewModels()
    private val userViewModel : UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailyReportsSendConfirmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        launch (Dispatchers.IO){
            val data = viewModel.reportsData
            launch(Dispatchers.Main) {
                binding.title.text = data.map{it.title}[0].toString()
                binding.date.text = data.map{it.date}[0].toString()
                binding.weeklyGoal.text = data.map{it.weeklyGoal}[0].toString()
                binding.commutingTimeBefore.text = data.map {it.commutingTimeBefore}[0].toString()
                binding.commutingTimeAfter.text = data.map{it.commutingTimeAfter}[0].toString()
                binding.participationPrograms.text = data.map{it.participationProgram}[0].toString()
                binding.detailsOfEfforts.text = data.map{it.detailsOfEfforts}[0].toString()
                binding.impressions.text = data.map{it.impressions}[0].toString()
                binding.meal.text = data.map{it.meal}[0].toString()
                binding.sleep.text = data.map{it.sleep}[0].toString()
                binding.motion.text = data.map{it.motion}[0].toString()
                binding.tirednessAndStress.text = data.map{it.tirednessAndStress}[0].toString()
                binding.remarks.text = data.map{it.remarks}[0].toString()
                binding.lookingBack.text = data.map{it.lookingBack}[0].toString()
                binding.nextWeekChallengeAndGoals.text = data.map{it.nextWeeksChallengeAndGoals}[0].toString()

            }
        }

        val body = StringBuilder()
        launch (Dispatchers.IO){
            val data = viewModel.reportsData
            launch(Dispatchers.Main) {
                body.append("件名："+ data.map{it.title}[0].toString())
                body.append("日付："+ data.map{it.date}[0].toString())
                body.append("週間目標："+ data.map{it.weeklyGoal}[0].toString())
                body.append("-----------------------")
                body.append("本日の報告内容【作業面】")
                body.append("通所時間：" + data.map {it.commutingTimeBefore}[0].toString() + "～" + data.map{it.commutingTimeAfter}[0].toString())
                body.append("参加プログラム："+ data.map{it.participationProgram}[0].toString())
                body.append("取り組み内容：" + data.map{it.detailsOfEfforts}[0].toString())
                body.append("所感：" + data.map{it.impressions}[0].toString())
                body.append("【生活面】")
                body.append("①食事：" + data.map{it.meal}[0].toString())
                body.append("②睡眠：" + data.map{it.sleep}[0].toString())
                body.append("③運動：" + data.map{it.motion}[0].toString())
                body.append("④疲れ・ストレス：" + data.map{it.tirednessAndStress}[0].toString())
                body.append("【備考】作業面・生活面以外の報告事項：" + data.map{it.remarks}[0].toString())
                body.append("----------------------")
                body.append("【一週間の総括】※その週の最後の通所日のみ入力")
                body.append("⑴振り返り：" + data.map{it.lookingBack}[0].toString())
                body.append("⑵次週の課題・目標：" + data.map { it.nextWeeksChallengeAndGoals }[0].toString() )

            }
        }
        body.toString().trimIndent()

        binding.submit.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
                StrictMode.setThreadPolicy(policy)
                val frag = mailSend(body.toString())
                if (frag) {
                    val intent = Intent(this@DailyReportsSendConfirmActivity, RequestDocumentsSendResultActivity::class.java)
                    startActivity(intent)
                } else {
                    //Toast.makeText(this@RequestDocumentsConfirmActivity, "メールが送信できませんでした。", Toast.LENGTH_LONG)
                    Log.d("[mailerror]", "XXX")
                }
            }
        })

        binding.backBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@DailyReportsSendConfirmActivity, RequestDocumentsConfirmActivity::class.java)
                startActivity(intent)
            }
        })
    }

    //メール送信部分
    fun mailSend(body: String): Boolean {

        //targetSDKversion30だとエラーでる
        //https://stackoverflow.com/questions/64650611/android-studio-verifyerror-rejecting-class-text-plain-from-javamail-api
        var userlist = userViewModel.emailList
        var userRecord = userlist.first()
        val fromEmail = userRecord.gmail // 送信元メールアドレス
        val password = "ihlpefzaeduqkcsh"  // 送信元メールパスワード
        val sendEmail = "fuflv4659@gmail.com" // 送信先メールアドレス
        val body = body                       // メール本文
        val subject = "資料請求"               // メール件名

        try {

            // メール送信先のサーバー情報
                val property = Properties()
                property["mail.smtp.host"] = "smtp.gmail.com" // SMTPサーバーホスト名
                property["mail.smtp.port"] = "465" // SMTPサーバーポート番号
                property["mail.smtp.socketFactory.port"] = "465" // SSL用
                property["mail.smtp.socketFactory.class"] = "javax.net.ssl.SSLSocketFactory" // SSL用

                // セッション
                val session =
                        Session.getDefaultInstance(property, object: Authenticator() {
                            override fun getPasswordAuthentication(): PasswordAuthentication {
                                return PasswordAuthentication(fromEmail, password)
                            }
                        })

                val mimeMsg = MimeMessage(session)
                mimeMsg.setSubject(subject, "utf-8")
                mimeMsg.setFrom(InternetAddress(fromEmail))
                mimeMsg.setRecipient(Message.RecipientType.TO, InternetAddress(sendEmail))

                // 本文設定
                val txtPart = MimeBodyPart()
                txtPart.setText(body, "utf-8")

                val mp: Multipart = MimeMultipart()
                mp.addBodyPart(txtPart)
                mimeMsg.setContent(mp)

                // メール送信
                val transport: Transport = session.getTransport("smtp")
                transport.connect(fromEmail, password)
                transport.sendMessage(mimeMsg, mimeMsg.allRecipients)
                transport.close()

                return true
            } catch (e: MessagingException) {
                println("exception = $e")
                return false
            } finally {
                // println("finish sending email")
            }
            return false
        }

}