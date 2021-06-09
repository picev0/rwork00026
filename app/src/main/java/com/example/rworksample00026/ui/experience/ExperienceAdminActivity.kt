package com.example.rworksample00026.ui.experience

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityExperienceAdminBinding
import com.example.rworksample00026.ui.util.ScopedAppActivity

class ExperienceAdminActivity : ScopedAppActivity() {

    private lateinit var binding: ActivityExperienceAdminBinding
    private val viewModel: ExperienceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExperienceAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.records.text = "レコード件数：　" + viewModel.personData.count().toString()
        //DatabaseUtils.queryNumEntries(db, DBOpenHelper.TABLE_NAME).toString()

        binding.deleteBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@ExperienceAdminActivity, ExperienceRecordDeleteConfirmActivity::class.java)
                startActivity(intent)
            }

        })
        binding.backBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@ExperienceAdminActivity, ExperienceFormFirstActivity::class.java)
                startActivity(intent)
            }
        })

    }
}