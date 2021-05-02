package com.example.rworksample00026.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityAttendantBinding
import com.example.rworksample00026.ui.dailyreports.DailyReportsFormFirstActivity

class AttendantActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAttendantBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAttendantBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.backBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@AttendantActivity, MainActivity::class.java)
                startActivity(intent)
            }
        })

        binding.reports.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@AttendantActivity, DailyReportsFormFirstActivity::class.java)
                startActivity(intent)
            }
        })
    }
}