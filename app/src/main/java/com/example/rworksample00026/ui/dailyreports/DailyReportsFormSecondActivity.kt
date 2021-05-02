package com.example.rworksample00026.ui.dailyreports

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.viewModels
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityDailyReportsFormSecondBinding
import com.example.rworksample00026.ui.UserViewModel
import com.example.rworksample00026.ui.util.ScopedAppActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DailyReportsFormSecondActivity : ScopedAppActivity() {

    private lateinit var binding: ActivityDailyReportsFormSecondBinding
    private val viewModel: DailyReportsViewModel by viewModels()
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailyReportsFormSecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.participationPrograms.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                launch { withContext(Dispatchers.Default) { viewModel.updateParticipationProgram(s.toString()) } }
            }
        })

        binding.detailsOfEfforts.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                launch { withContext(Dispatchers.Default){ viewModel.updateDetailsOfEffects(s.toString()) } }
            }
        })

        binding.impressions.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                launch { withContext(Dispatchers.Default){ viewModel.updateImpressions(s.toString()) } }
            }
        })

        launch (Dispatchers.IO){
            val userData = userViewModel.emailList
            launch (Dispatchers.Main){
                binding.name.text = userData.map{ it.name }[0].toString()

            }
        }
        launch { withContext(Dispatchers.Default) { viewModel.updateName(binding.name.text.toString()) } }

        binding.meal.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                launch { withContext(Dispatchers.Default) { viewModel.updateMeal(s.toString()) } }
            }
        })

        binding.sleep.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                launch {  withContext(Dispatchers.Default){viewModel.updateSleep(s.toString())} }
            }
        })

        binding.motion.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                launch {  withContext(Dispatchers.Default){viewModel.updateMotion(s.toString())} }
            }
        })


        binding.nextPageBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@DailyReportsFormSecondActivity, DailyReportsFormThirdActivity::class.java)
                startActivity(intent)
            }
        })

        binding.sentMailListBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@DailyReportsFormSecondActivity, SentDailyReportsListActivity::class.java)
                startActivity(intent)
            }
        })
    }
}