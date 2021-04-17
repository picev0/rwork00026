package com.example.rworksample00026.ui.requestdocuments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityRequestDocumentsRecordDeleteResultBinding

class RequestDocumentsRecordDeleteResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRequestDocumentsRecordDeleteResultBinding
    private val viewModel: RequestDocumentsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRequestDocumentsRecordDeleteResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@RequestDocumentsRecordDeleteResultActivity, RequestDocumentsRecordDeleteConfirmActivity::class.java)
                startActivity(intent)
            }
        })
    }
}