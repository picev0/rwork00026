package com.example.rworksample00026.ui.dailyreports

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityDailyReportsSendResultBinding
import com.example.rworksample00026.databinding.ActivityRequestDocumentsSendResultBinding
import com.example.rworksample00026.ui.AttendantActivity
import com.example.rworksample00026.ui.util.ScopedAppActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DailyReportsSendResultActivity : ScopedAppActivity() {

    private lateinit var binding : ActivityDailyReportsSendResultBinding
    private val viewModel: DailyReportsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailyReportsSendResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                launch {
                    withContext(Dispatchers.Default) {
                        
                    }
                }
                val intent = Intent(this@DailyReportsSendResultActivity, AttendantActivity::class.java)
                startActivity(intent)

            }
        })
    }
}