package com.example.rworksample00026.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.beardedhen.androidbootstrap.BootstrapText
import com.example.rworksample00026.StaffActivity
import com.example.rworksample00026.databinding.ActivityMainBinding
import com.example.rworksample00026.ui.beginner.BeginnerActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setSupportActionBar(binding.toolBar)

        //binding.toolBar.setTitle("ハローワールド")

        binding.requestDocumentsBtn.setOnClickListener (object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(this@MainActivity, AgreeActivity::class.java)
                intent.putExtra("stmt", "資料請求")
                startActivity(intent)
            }
        })

        binding.experienceBtn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                val intent = Intent(this@MainActivity, AgreeActivity::class.java)
                intent.putExtra("stmt", "相談する")
                startActivity(intent)
            }
        })

        binding.beginnerBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(p0: View?) {
                val intent = Intent(this@MainActivity, BeginnerActivity::class.java)
                startActivity(intent)
            }
        })

        binding.attendantBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@MainActivity, AuthActivity::class.java)
                startActivity(intent)
            }
        })

        binding.staffBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@MainActivity, StaffActivity::class.java)
                startActivity(intent)
            }
        })

        val builder = BootstrapText.Builder(applicationContext)
        val bootstrapText1 = builder.addText("ニューロリワーク　").addFontAwesomeIcon("fa_heart").build()
        binding.awesomeTextview1.setBootstrapText(bootstrapText1)
    }
}