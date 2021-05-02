package com.example.rworksample00026.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rworksample00026.databinding.ActivityAgreeBinding
import com.example.rworksample00026.ui.experience.ExperienceFormFirstActivity
import com.example.rworksample00026.ui.requestdocuments.RequestDocumentsFormFirstActivity

class AgreeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAgreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gotobrowse.setOnClickListener (object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://hworld-rework.com/privacy"))
                startActivity(intent)
            }
        })

        val stmt = intent.getStringExtra("stmt")
        if (stmt.equals("資料請求")) {
            binding.nextPageBtn.setOnClickListener (object : View.OnClickListener{
                override fun onClick(v: View?) {
                    val intent = Intent(this@AgreeActivity, RequestDocumentsFormFirstActivity::class.java)
                    startActivity(intent)
                }
            })
        }

        if (stmt.equals("相談する")) {
            binding.nextPageBtn.setOnClickListener (object : View.OnClickListener{
                override fun onClick(v: View?) {
                    val intent = Intent(this@AgreeActivity, ExperienceFormFirstActivity::class.java)
                    startActivity(intent)
                }
            })
        }
    }
}