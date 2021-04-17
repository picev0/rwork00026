package com.example.rworksample00026.ui.experience

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityExperienceFormFirstBinding

class ExperienceFormFirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExperienceFormFirstBinding
    private val viewModel : ExperienceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExperienceFormFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}