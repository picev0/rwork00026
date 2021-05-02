package com.example.rworksample00026.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rworksample00026.StaffActivity
import com.example.rworksample00026.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
    }
}