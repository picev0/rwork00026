package com.example.rworksample00026.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.rworksample00026.databinding.ActivityUserDatabaseAdminBinding

class UserDatabaseAdminActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDatabaseAdminBinding
    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDatabaseAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.records.text = "レコード件数：　" + viewModel.emailList.count().toString()
        if (intent.getStringExtra("DB").equals("DBManagement")) {
            binding.backBtn.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {

                }
            })
        }
        binding.deleteBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@UserDatabaseAdminActivity, UserDatabaseRecordDeleteConfirmActivity::class.java)
                startActivity(intent)
            }
        })
    }
}