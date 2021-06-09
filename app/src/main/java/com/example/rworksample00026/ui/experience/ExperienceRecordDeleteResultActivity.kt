package com.example.rworksample00026.ui.experience

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityExperienceRecordDeleteResultBinding
import com.example.rworksample00026.databinding.ActivityRequestDocumentsRecordDeleteResultBinding

class ExperienceRecordDeleteResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExperienceRecordDeleteResultBinding
    private val viewModel: ExperienceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExperienceRecordDeleteResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@ExperienceRecordDeleteResultActivity, ExperienceRecordDeleteConfirmActivity::class.java)
                startActivity(intent)
            }
        })
    }
}