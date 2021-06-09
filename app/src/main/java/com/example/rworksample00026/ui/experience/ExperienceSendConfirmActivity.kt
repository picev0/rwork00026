package com.example.rworksample00026.ui.experience

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityExperienceSendConfirmBinding
import com.example.rworksample00026.databinding.ActivityRequestDocumentsSendConfirmBinding
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

class ExperienceSendConfirmActivity : ScopedAppActivity() {

    private lateinit var binding: ActivityExperienceSendConfirmBinding
    private val viewModel: ExperienceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExperienceSendConfirmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        launch (Dispatchers.IO){
            val data = viewModel.personData
            launch(Dispatchers.Main) {
                binding.name.text = data.map{it.name}[0].toString()
                binding.phoneticGuides.text = data.map{it.phoneticGuides}[0].toString()
                binding.birthday.text = data.map{it.birthday}[0].toString()
                binding.mailAddress.text = data.map {it.mailAddress}[0].toString()
                binding.phoneNumber.text = data.map{it.phoneNumber}[0].toString()
                binding.zipStr.text = data.map{it.zipStr}[0].toString()
                binding.prefecture.text = data.map{it.prefecture}[0].toString()
                binding.city.text = data.map{it.city}[0].toString()
                binding.address.text = data.map{it.address}[0].toString()
                binding.disableCertificate.text = data.map{it.disableCertifidate}[0].toString()
                binding.desiredDateFirstCandidate.text = data.map{it.desiredDateFirstCandidate}[0].toString()
                binding.desiredDateSecondCandidate.text = data.map{it.desiredDateSecondCandidate}[0].toString()
                binding.desiredDateThirdCandidate.text = data.map{it.desiredDateThirdCandidate}[0].toString()
                binding.remarks.text = data.map{it.remarks}[0].toString()

            }
        }

        val body = StringBuilder()
        launch (Dispatchers.IO){
            val data = viewModel.personData
            launch(Dispatchers.Main) {
                body.append("お名前："+ data.map{it.name}[0].toString())
                body.append("ふりがな："+ data.map{it.phoneticGuides}[0].toString())
                body.append("生年月日："+ data.map{it.birthday}[0].toString())
                body.append("メールアドレス：" + data.map {it.mailAddress}[0].toString())
                body.append("電話番号："+ data.map{it.phoneNumber}[0].toString())
                body.append("郵便番号：" + data.map{it.zipStr}[0].toString())
                body.append("住所/都道府県：" + data.map{it.prefecture}[0].toString())
                body.append("市区町村：" + data.map{it.city}[0].toString())
                body.append("丁目・番地：" + data.map{it.address}[0].toString())
                body.append("障害者手帳の有無：" + data.map{it.disableCertifidate}[0].toString())
                body.append("希望日(第一候補)：" + data.map{it.desiredDateFirstCandidate}[0].toString())
                body.append("希望日(第二候補)：" + data.map{it.desiredDateSecondCandidate}[0].toString())
                body.append("希望日(第三候補)：" + data.map{it.desiredDateThirdCandidate}[0].toString())
                body.append("備考：" + data.map{it.remarks}[0].toString())

            }
        }
        body.toString().trimIndent()



        binding.submit.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
                StrictMode.setThreadPolicy(policy)
                val frag = mailSend(body.toString())
                if (frag) {
                    val intent = Intent(this@ExperienceSendConfirmActivity, ExperienceSendResultActivity::class.java)
                    startActivity(intent)
                } else {
                    //Toast.makeText(this@RequestDocumentsConfirmActivity, "メールが送信できませんでした。", Toast.LENGTH_LONG)
                    Log.d("[mailerror]", "XXX")
                }
            }
        })

        binding.backBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@ExperienceSendConfirmActivity, ExperienceFormConfirmActivity::class.java)
                startActivity(intent)
            }
        })
    }



    //メール送信部分
    fun mailSend(body: String): Boolean {

        //targetSDKversion30だとエラーでる
        //https://stackoverflow.com/questions/64650611/android-studio-verifyerror-rejecting-class-text-plain-from-javamail-api

        val fromEmail = "smurata16@gmail.com" // 送信元メールアドレス
        val password = "ihlpefzaeduqkcsh"  // 送信元メールパスワード
        val sendEmail = "fuflv4659@gmail.com" // 送信先メールアドレス
        val body = body                       // メール本文
        val subject = "相談予約"               // メール件名

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