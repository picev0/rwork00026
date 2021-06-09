package com.example.rworksample00026.ui.dailyreports

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.rworksample00026.databinding.ActivitySentDailyReportsDetailBinding
import com.example.rworksample00026.ui.util.ScopedAppActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SentDailyReportsDetailActivity : ScopedAppActivity() {

    private lateinit var binding : ActivitySentDailyReportsDetailBinding
    private val viewModel: DailyReportsViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySentDailyReportsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)



        //var point = getResources().getString(getIntent().getIntExtra("position"))
        //val point = intent.getStringExtra("position")
        //Log.d("[position]", point)
        //val position = point.toInt()
        /*
        // 非同期で入力値を表示(1件だけ)
        launch (Dispatchers.IO){
            val data = viewModel.reportsData

            launch (Dispatchers.Main){
                binding.title.setText(data.map { it.title }[position].toString())
                binding.weeklyGoal.setText(data.map { it.weeklyGoal }[position].toString() )
                binding.commutingTimeBefore.setText(data.map { it.commutingTimeBefore }[position].toString() )
                binding.commutingTimeAfter.setText(data.map { it.commutingTimeAfter }[position].toString() )
                binding.participationProgram.setText(data.map{it.participationProgram}[position].toString())
                binding.detailsOfEfforts.setText(data.map{it.detailsOfEfforts}[position].toString())
                binding.impressions.setText(data.map{it.impressions}[position].toString())
                binding.meal.setText(data.map{it.meal}[position].toString())
                binding.sleep.setText(data.map{it.sleep}[position].toString())
                binding.motion.setText(data.map{it.motion}[position].toString())
                binding.tirednessAndStress.setText(data.map{it.tirednessAndStress}[position].toString())
                binding.remarks.setText(data.map{it.remarks}[position].toString())
                binding.lookingBack.setText(data.map{it.lookingBack}[position].toString())
                binding.nextWeekChallengeAndGoals.setText(data.map{it.nextWeeksChallengeAndGoals}[position].toString())
            }
        }*/

        binding.Btn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@SentDailyReportsDetailActivity, SentDailyReportsListActivity::class.java)
                startActivity(intent)
            }
        })
    }
}