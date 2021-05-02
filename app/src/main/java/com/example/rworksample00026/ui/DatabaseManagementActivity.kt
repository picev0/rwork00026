package com.example.rworksample00026.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rworksample00026.R
import com.example.rworksample00026.StaffActivity
import com.example.rworksample00026.databinding.ActivityDatabaseManagementBinding
import com.example.rworksample00026.ui.dailyreports.DailyReportsAdminActivity
import com.example.rworksample00026.ui.requestdocuments.RequestDocumentsAdminActivity

class DatabaseManagementActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDatabaseManagementBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatabaseManagementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.requestDocumentDatabaseManagement.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@DatabaseManagementActivity, RequestDocumentsAdminActivity::class.java)
                intent.putExtra("DB","DB管理")
                startActivity(intent)
            }
        })

        binding.trialDatabaseManagement.setOnClickListener (object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent()
            }
        })

        binding.userDatabaseManagement.setOnClickListener (object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@DatabaseManagementActivity, UserDatabaseAdminActivity::class.java)
                intent.putExtra("DB", "DB管理")
                startActivity(intent)
            }
        })

        binding.dailyReportDatabaseManagement.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@DatabaseManagementActivity, DailyReportsAdminActivity::class.java)
                intent.putExtra("DB", "DB管理")
                startActivity(intent)
            }
        })
    }
}