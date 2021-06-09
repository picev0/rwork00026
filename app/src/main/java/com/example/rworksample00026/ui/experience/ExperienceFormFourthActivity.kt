package com.example.rworksample00026.ui.experience

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import androidx.activity.viewModels
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityExperienceFormFourthBinding
import com.example.rworksample00026.databinding.ActivityExperienceFormSecondBinding
import com.example.rworksample00026.ui.UserViewModel
import com.example.rworksample00026.ui.util.ScopedAppActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*

class ExperienceFormFourthActivity : ScopedAppActivity() {

    private lateinit var binding: ActivityExperienceFormFourthBinding
    private val viewModel: ExperienceViewModel by viewModels()
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExperienceFormFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nextPageBtn.setOnClickListener (object : View.OnClickListener{
            override fun onClick(v: View?) {
                //https://qiita.com/kumamotone/items/8972dc5732a48c90f0dd
                //withContext
                //DBにデータ投入
                launch{ withContext(Dispatchers.Default){viewModel.updateParamSecond(binding.tvDesiredDateThirdCandidate.text.toString() + " " + binding.tvDesiredDateThirdCandidateTime.text.toString(), binding.remarks.text.toString())} }


                val intent = Intent(this@ExperienceFormFourthActivity, ExperienceFormConfirmActivity::class.java)
                startActivity(intent)
            }
        })
        binding.dateInputThird.setOnClickListener (object:View.OnClickListener{
            override fun onClick(v: View?) {
                showDatePickerThird()
            }
        })

        binding.timeInputThird.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                showTimePickerThird()
            }
        })
    }

    private fun showDatePickerThird() {

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener() { view, year, month, dayOfMonth->
                binding.tvDesiredDateThirdCandidate.text = "${year}/${month + 1}/${dayOfMonth}"
            },
            year,
            month,
            day)
        datePickerDialog.show()
    }

    fun showTimePickerThird(){
        val calendar: Calendar = Calendar.getInstance()

        val cal = Calendar.getInstance()
        val timeSetListener = TimePickerDialog.OnTimeSetListener{
                view: TimePicker?, hourOfDay: Int, minute: Int ->

            cal.set(Calendar.HOUR_OF_DAY, hourOfDay)
            cal.set(Calendar.MINUTE, minute)
            binding.tvDesiredDateThirdCandidateTime.text = SimpleDateFormat("HH : mm").format(cal.time)

        }

        TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
    }
}