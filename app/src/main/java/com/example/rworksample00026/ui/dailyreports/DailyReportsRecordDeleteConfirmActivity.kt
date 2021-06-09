package com.example.rworksample00026.ui.dailyreports

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityDailyReportsRecordDeleteConfirmBinding
import com.example.rworksample00026.ui.util.ScopedAppActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DailyReportsRecordDeleteConfirmActivity : ScopedAppActivity() {

    private lateinit var binding: ActivityDailyReportsRecordDeleteConfirmBinding
    private val viewModel: DailyReportsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailyReportsRecordDeleteConfirmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        launch (Dispatchers.IO) {

            val data = viewModel.reportsData
            val count = viewModel.reportsData.count() - 1
            launch(Dispatchers.Main) {
                Log.d("[count2]", count.toString())
                binding.title.setText( data.map { it.title }[0].toString())
                binding.weeklyGoal.setText( data.map { it.weeklyGoal }[0].toString() )
                binding.commutingTimeBefore.setText( data.map { it.commutingTimeBefore }[0].toString() )
                binding.commutingTimeAfter.setText(data.map { it.commutingTimeAfter }[0].toString() )
                binding.participationProgram.setText(data.map{it.participationProgram}[0].toString())
                binding.detailsOfEfforts.setText(data.map{it.detailsOfEfforts}[0].toString())
                binding.impressions.setText(data.map{it.impressions}[0].toString())
                binding.meal.setText(data.map{it.meal}[0].toString())
                binding.sleep.setText(data.map{it.sleep}[0].toString())
                binding.motion.setText(data.map{it.motion}[0].toString())
                binding.tirednessAndStress.setText(data.map{it.tirednessAndStress}[0].toString())
                binding.remarks.setText(data.map{it.remarks}[0].toString())
                binding.lookingBack.setText(data.map{it.lookingBack}[0].toString())
                binding.nextWeekChallengeAndGoals.setText(data.map{it.nextWeeksChallengeAndGoals}[0].toString())

            }

        }

    }
}