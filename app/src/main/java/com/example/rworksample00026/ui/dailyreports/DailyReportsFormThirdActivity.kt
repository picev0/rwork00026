package com.example.rworksample00026.ui.dailyreports

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityDailyReportsFormThirdBinding

class DailyReportsFormThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDailyReportsFormThirdBinding
    private val viewModel: DailyReportsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailyReportsFormThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}