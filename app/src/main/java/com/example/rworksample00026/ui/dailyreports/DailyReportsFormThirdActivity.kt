package com.example.rworksample00026.ui.dailyreports

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.viewModels
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityDailyReportsFormThirdBinding
import com.example.rworksample00026.ui.util.ScopedAppActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DailyReportsFormThirdActivity : ScopedAppActivity() {

    private lateinit var binding: ActivityDailyReportsFormThirdBinding
    private val viewModel: DailyReportsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailyReportsFormThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tirednessAndStress.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                launch { withContext(Dispatchers.Default){ viewModel.updateTirednessAndStress(s.toString()) } }
            }
        })

        binding.remarks.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                launch { withContext(Dispatchers.Default){ viewModel.updateRemarks(s.toString()) } }
            }
        })

        //テキストが変更されたら
        binding.lookingBack.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                launch { withContext(Dispatchers.Default) { viewModel.updateLookingBack(s.toString()) } }
            }
        })

        binding.nextWeekChallengeAndGoals.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                launch { withContext(Dispatchers.Default){ viewModel.updateNextWeekChallengeAndGoals(s.toString()) } }
            }
        })

        binding.nextPageBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@DailyReportsFormThirdActivity, DailyReportsConfirmActivity::class.java)
                startActivity(intent)
            }
        })

        binding.sentMailListBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@DailyReportsFormThirdActivity, SentDailyReportsListActivity::class.java)
                startActivity(intent)
            }
        })
    }
}