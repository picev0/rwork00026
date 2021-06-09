package com.example.rworksample00026.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rworksample00026.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nextPageBtn.setOnClickListener (object : View.OnClickListener{
            override fun onClick(p0: View?) {
                val intent = Intent(this@SecondActivity, ThirdActivity::class.java)
                startActivity(intent)
            }
        })

        binding.skipBtn.setOnClickListener (object : View.OnClickListener{
            override fun onClick(p0: View?) {
                val intent = Intent(this@SecondActivity, MainActivity::class.java)
                startActivity(intent)
            }
        })
    }
}