package com.example.rworksample00026.ui.dailyreports

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.activity.viewModels
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityDailyReportsFormFirstBinding
import com.example.rworksample00026.ui.UserViewModel
import com.example.rworksample00026.ui.util.DatePickDailyReports
import com.example.rworksample00026.ui.util.ScopedAppActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*

class DailyReportsFormFirstActivity : ScopedAppActivity(), DatePickerDialog.OnDateSetListener {

    private lateinit var binding: ActivityDailyReportsFormFirstBinding
    private val viewModel: DailyReportsViewModel by viewModels()
    private val userViewModel : UserViewModel by viewModels()
    var titleName = Any()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailyReportsFormFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val current = SimpleDateFormat("yyyy年MM月dd日").format(Date())
        //var name = StringBuilder()
        var userName = userViewModel.emailList[0].name
        binding.title.setText(userName + "　日報報告書＿" + current)
        titleName = userName + "　日報報告書＿" + current

        binding.timeBeforeButton.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                showTimePickerDialogBefore()
            }
        })

        binding.timeAfterButton.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                showTimePickerDialogAfter()
            }
        })

        binding.adminPageBtn.setOnClickListener (object :View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@DailyReportsFormFirstActivity, DailyReportsAdminActivity::class.java)
                intent.putExtra("reports", "reports")
                startActivity(intent)
            }
        })

        binding.nextPageBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                launch {
                    withContext(Dispatchers.Main){ viewModel.updateTitle(titleName as String) }
                }
                val intent = Intent(this@DailyReportsFormFirstActivity, DailyReportsFormSecondActivity::class.java)
                startActivity(intent)
            }
        })

        binding.sentMailListBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@DailyReportsFormFirstActivity, SentDailyReportsListActivity::class.java)
                startActivity(intent)
            }
        })
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val str = String.format(Locale.US, "%d/%d/%d", year, month+1, dayOfMonth)
        binding.tvDate.setText(str)
        //Log.d("[str]",str)
        launch { withContext(Dispatchers.Default) { viewModel.insertReport(str) }}
    }

    fun showDatePickerDialog(v: View){
        val newFragment = DatePickDailyReports()
        newFragment.show(supportFragmentManager, "datePicker")
    }
    // 通所時間入力部分
    /*
    *https://blog.dreamhanks.com/15-%E3%80%90android-kotlin%E3%80%91timepickerdialog/
    * */

    fun showTimePickerDialogBefore(){
        val calendar: Calendar = Calendar.getInstance()

        val cal = Calendar.getInstance()
        val timeSetListener = TimePickerDialog.OnTimeSetListener{
            view: TimePicker?, hourOfDay: Int, minute: Int ->

            cal.set(Calendar.HOUR_OF_DAY, hourOfDay)
            cal.set(Calendar.MINUTE, minute)
            binding.tvTimeBefore.setText(SimpleDateFormat("HH : mm").format(cal.time))
            launch { withContext(Dispatchers.Default) { viewModel.updateCommutingTimeBefore(SimpleDateFormat("HH : mm").format(cal.time)) } }
        }

        TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
    }

    fun showTimePickerDialogAfter(){
        val calendar: Calendar = Calendar.getInstance()

        val cal = Calendar.getInstance()
        val timeSetListener = TimePickerDialog.OnTimeSetListener{
            view: TimePicker?, hourOfDay: Int, minute: Int ->

            cal.set(Calendar.HOUR_OF_DAY, hourOfDay)
            cal.set(Calendar.MINUTE, minute)
            binding.tvTimeAfter.setText(SimpleDateFormat("HH : mm").format(cal.time))
            launch { withContext(Dispatchers.Default) { viewModel.updateCommutingTimeAfter(SimpleDateFormat("HH : mm").format(cal.time)) } }
        }

        TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
    }
}