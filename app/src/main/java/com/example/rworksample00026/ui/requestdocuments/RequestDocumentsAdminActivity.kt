package com.example.rworksample00026.ui.requestdocuments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityRequestDocumentsAdminBinding
import com.example.rworksample00026.ui.util.ScopedAppActivity

class RequestDocumentsAdminActivity : ScopedAppActivity() {

    private lateinit var binding: ActivityRequestDocumentsAdminBinding
    private val viewModel: RequestDocumentsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRequestDocumentsAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.records.text = "レコード件数：　" + viewModel.personData.count().toString()
        //DatabaseUtils.queryNumEntries(db, DBOpenHelper.TABLE_NAME).toString()

        binding.deleteBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@RequestDocumentsAdminActivity, RequestDocumentsRecordDeleteConfirmActivity::class.java)
                startActivity(intent)
            }

        })
        binding.backBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@RequestDocumentsAdminActivity, RequestDocumentsFormFirstActivity::class.java)
                startActivity(intent)
            }
        })

    }
}