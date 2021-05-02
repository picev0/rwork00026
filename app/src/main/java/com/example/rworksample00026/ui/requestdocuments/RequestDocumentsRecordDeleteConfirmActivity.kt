package com.example.rworksample00026.ui.requestdocuments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityRequestDocumentsRecordDeleteConfirmBinding
import com.example.rworksample00026.ui.util.ScopedAppActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RequestDocumentsRecordDeleteConfirmActivity : ScopedAppActivity() {

    private lateinit var binding: ActivityRequestDocumentsRecordDeleteConfirmBinding
    private val viewModel: RequestDocumentsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRequestDocumentsRecordDeleteConfirmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        launch (Dispatchers.IO) {

            val data = viewModel.personData
            val count = viewModel.personData.count() - 1
            launch(Dispatchers.Main) {
                Log.d("[count2]", count.toString())
                binding.name.text = data.map { it.name }[count].toString()
                binding.phoneticGuides.text = data.map { it.phoneticGuides }[count].toString()
                binding.birthday.text = data.map { it.birthday }[count].toString()
                binding.mailAddress.text = data.map { it.mailAddress }[count].toString()
                binding.phoneNumber.text = data.map { it.phoneNumber }[count].toString()
                binding.zipStr.text = data.map { it.zipStr }[count].toString()
                binding.prefecture.text = data.map { it.prefecture }[count].toString()
                binding.city.text = data.map { it.city }[count].toString()
                binding.address.text = data.map { it.address }[count].toString()
                binding.disableCertificate.text = data.map { it.disableCertifidate }[count].toString()
                binding.sendingMaterials.text = data.map { it.sendingMaterials }[count].toString()
                binding.remarks.text = data.map { it.remarks }[count].toString()


            }

        }


        // 削除
        binding.deleteBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                launch {
                    withContext(Dispatchers.Default) {
                        viewModel.deleteLastRecord()
                    }
                }
                val intent = Intent(this@RequestDocumentsRecordDeleteConfirmActivity, RequestDocumentsRecordDeleteResultActivity::class.java)
                startActivity(intent)

            }
        })

        // 戻る
        binding.backBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@RequestDocumentsRecordDeleteConfirmActivity, RequestDocumentsFormFirstActivity::class.java)
                startActivity(intent)
            }
        })
    }
}