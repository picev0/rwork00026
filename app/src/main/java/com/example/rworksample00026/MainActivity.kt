package com.example.rworksample00026

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rworksample00026.databinding.ActivityMainBinding
import com.example.rworksample00026.ui.AuthActivity

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