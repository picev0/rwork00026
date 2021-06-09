package com.example.rworksample00026.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rworksample00026.databinding.ActivityUserDatabaseRecordDeleteConfirmBinding
import com.example.rworksample00026.databinding.ActivityUserDatabaseRecordDeleteResultBinding

class UserDatabaseRecordDeleteResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDatabaseRecordDeleteResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDatabaseRecordDeleteResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}