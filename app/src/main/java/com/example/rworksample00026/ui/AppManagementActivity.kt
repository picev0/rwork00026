package com.example.rworksample00026.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rworksample00026.StaffActivity
import com.example.rworksample00026.databinding.ActivityAppManagementBinding

class AppManagementActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppManagementBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppManagementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.detabaseManagement.setOnClickListener (object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@AppManagementActivity, DatabaseManagementActivity::class.java)
                startActivity(intent)
            }
        })

        binding.backBtn.setOnClickListener (object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@AppManagementActivity, StaffActivity::class.java)
                startActivity(intent)
            }
        })
    }
}