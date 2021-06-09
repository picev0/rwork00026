package com.example.rworksample00026.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityExperienceRecordDeleteConfirmBinding
import com.example.rworksample00026.databinding.ActivityUserDatabaseRecordDeleteConfirmBinding
import com.example.rworksample00026.ui.util.ScopedAppActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserDatabaseRecordDeleteConfirmActivity : ScopedAppActivity() {

    private lateinit var binding: ActivityUserDatabaseRecordDeleteConfirmBinding
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDatabaseRecordDeleteConfirmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        launch(Dispatchers.IO){
        val data = userViewModel.emailList
        val count = userViewModel.emailList.count() - 1
        launch(Dispatchers.Main) {
            Log.d("[count2]", count.toString())
            binding.name.text = data.map { it.name }[count].toString()
            binding.gmail.text = data.map { it.gmail }[count].toString()

        }

    }


}
}