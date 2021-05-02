package com.example.rworksample00026.ui.dailyreports

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityDailyReportsAdminBinding
import com.example.rworksample00026.ui.DatabaseManagementActivity

class DailyReportsAdminActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDailyReportsAdminBinding
    private val viewModel: DailyReportsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailyReportsAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.records.text = "レコード件数：　" + viewModel.reportsData.count().toString()


            binding.backBtn.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    if (intent.getStringExtra("DB").equals("DB管理")) {
                        val intent = Intent(
                            this@DailyReportsAdminActivity,
                            DatabaseManagementActivity::class.java
                        )
                        startActivity(intent)
                    }
                }
            })



            binding.backBtn.setOnClickListener (object : View.OnClickListener{
                override fun onClick(v: View?) {
                    if (intent.getStringExtra("reports").equals("reports")) {
                        val intent = Intent(this@DailyReportsAdminActivity, DailyReportsFormFirstActivity::class.java)
                        startActivity(intent)
                    }
                }
            })

    }
}