package com.example.rworksample00026.ui.requestdocuments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityRequestDocumentsSendResultBinding
import com.example.rworksample00026.ui.util.ScopedAppActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RequestDocumentsSendResultActivity : ScopedAppActivity() {

    private lateinit var binding : ActivityRequestDocumentsSendResultBinding
    private val viewModel: RequestDocumentsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRequestDocumentsSendResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                launch {
                    withContext(Dispatchers.Default) {
                        viewModel.deleteFirstRecord()
                    }
                }
            }
        })
    }
}