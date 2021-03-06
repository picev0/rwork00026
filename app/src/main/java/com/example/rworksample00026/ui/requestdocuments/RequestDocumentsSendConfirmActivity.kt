package com.example.rworksample00026.ui.requestdocuments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.rworksample00026.R
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

class RequestDocumentsSendConfirmActivity : ScopedAppActivity() {

    private lateinit var binding: ActivityRequestDocumentsSendConfirmBinding
    private val viewModel: RequestDocumentsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRequestDocumentsSendConfirmBinding.inflate(layoutInflater)
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
                binding.sendingMaterials.text = data.map{it.sendingMaterials}[0].toString()
                binding.remarks.text = data.map{it.remarks}[0].toString()

            }
        }

        val body = StringBuilder()
        launch (Dispatchers.IO){
            val data = viewModel.personData
            launch(Dispatchers.Main) {
                body.append("????????????"+ data.map{it.name}[0].toString())
                body.append("???????????????"+ data.map{it.phoneticGuides}[0].toString())
                body.append("???????????????"+ data.map{it.birthday}[0].toString())
                body.append("????????????????????????" + data.map {it.mailAddress}[0].toString())
                body.append("???????????????"+ data.map{it.phoneNumber}[0].toString())
                body.append("???????????????" + data.map{it.zipStr}[0].toString())
                body.append("??????/???????????????" + data.map{it.prefecture}[0].toString())
                body.append("???????????????" + data.map{it.city}[0].toString())
                body.append("??????????????????" + data.map{it.address}[0].toString())
                body.append("???????????????????????????" + data.map{it.disableCertifidate}[0].toString())
                body.append("????????????????????????????????????" + data.map{it.sendingMaterials}[0].toString())
                body.append("?????????" + data.map{it.remarks}[0].toString())

            }
        }
        body.toString().trimIndent()



        binding.submit.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
                StrictMode.setThreadPolicy(policy)
                val frag = mailSend(body.toString())
                if (frag) {
                    val intent = Intent(this@RequestDocumentsSendConfirmActivity, RequestDocumentsSendResultActivity::class.java)
                    startActivity(intent)
                } else {
                    //Toast.makeText(this@RequestDocumentsConfirmActivity, "?????????????????????????????????????????????", Toast.LENGTH_LONG)
                    Log.d("[mailerror]", "XXX")
                }
            }
        })

        binding.backBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@RequestDocumentsSendConfirmActivity, RequestDocumentsConfirmActivity::class.java)
                startActivity(intent)
            }
        })
    }



    //?????????????????????
    fun mailSend(body: String): Boolean {

        //targetSDKversion30?????????????????????
        //https://stackoverflow.com/questions/64650611/android-studio-verifyerror-rejecting-class-text-plain-from-javamail-api

        val fromEmail = "smurata16@gmail.com" // ??????????????????????????????
        val password = "ihlpefzaeduqkcsh"  // ?????????????????????????????????
        val sendEmail = "fuflv4659@gmail.com" // ??????????????????????????????
        val body = body                       // ???????????????
        val subject = "????????????"               // ???????????????

        try {

            // ???????????????????????????????????????
            val property = Properties()
            property["mail.smtp.host"] = "smtp.gmail.com" // SMTP????????????????????????
            property["mail.smtp.port"] = "465" // SMTP???????????????????????????
            property["mail.smtp.socketFactory.port"] = "465" // SSL???
            property["mail.smtp.socketFactory.class"] = "javax.net.ssl.SSLSocketFactory" // SSL???

            // ???????????????
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

            // ????????????
            val txtPart = MimeBodyPart()
            txtPart.setText(body, "utf-8")

            val mp: Multipart = MimeMultipart()
            mp.addBodyPart(txtPart)
            mimeMsg.setContent(mp)

            // ???????????????
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