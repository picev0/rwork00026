package com.example.rworksample00026

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rworksample00026.databinding.ActivityStaffBinding
import com.example.rworksample00026.ui.AppManagementActivity
import com.example.rworksample00026.ui.MainActivity

class StaffActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStaffBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStaffBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.appManagement.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@StaffActivity, AppManagementActivity::class.java)
                startActivity(intent)
            }
        })

        binding.backBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@StaffActivity, MainActivity::class.java)
                startActivity(intent)
            }
        })
    }
}