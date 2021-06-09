package com.example.rworksample00026.ui.dailyreports

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.*
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

class DailyReportsFormFirstActivity : ScopedAppActivity(), DatePickerDialog.OnDateSetListener{

    private lateinit var binding: ActivityDailyReportsFormFirstBinding
    private val viewModel: DailyReportsViewModel by viewModels()
    private val userViewModel : UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailyReportsFormFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val current = SimpleDateFormat("yyyy年MM月dd日").format(Date())
        //var name = StringBuilder()
        var userName = ""
        if(userViewModel.emailList.count() >= 1){
            userName = userViewModel.emailList[0].name
            binding.title.setText("$userName　日報報告書＿$current")
        }
        //binding.title.setText("$userName　日報報告書＿$current")


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
                val check = validationCheck(binding.title, binding.weeklyGoal, binding.tvDate, binding.tvTimeBefore, binding.tvTimeAfter)
                if (check) {
                    launch {
                        withContext(Dispatchers.Main) {
                            viewModel.insertReportParam(binding.title.text.toString(), binding.weeklyGoal.text.toString(), binding.tvDate.text.toString(), binding.tvTimeBefore.text.toString(), binding.tvTimeAfter.text.toString())
                        }
                    }
                    val intent = Intent(this@DailyReportsFormFirstActivity, DailyReportsFormSecondActivity::class.java)
                    startActivity(intent)
                }
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
            binding.tvTimeBefore.text = SimpleDateFormat("HH : mm").format(cal.time)

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
            binding.tvTimeAfter.text = SimpleDateFormat("HH : mm").format(cal.time)

        }

        TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
    }

    fun validationCheck(title: EditText, weeklyGoal: EditText, tvDate: TextView, tvTimeBefore: TextView, tvTimeAfter: TextView) : Boolean {
        /**
         *
         * バリデーションチェック
         *
         *
         * メールアドレスに@が含まれるか
         */
        if (binding.title.text.toString().length == 0) {
            //タイトルの入力エリアをフォーカスさせる
            //binding.title.requestFocus()
            //Log.d("[name]", "XXX")
            //画面の下にToastエラーメッセージを表示
            Toast.makeText(applicationContext, "件名が未入力です。", Toast.LENGTH_SHORT).show()
            return false
        }

        if (binding.weeklyGoal.text.toString().length == 0){
            //週間目標の入力エリアをフォーカスさせる
            //binding.weeklyGoal.requestFocus()
            //Log.d("[mail]", "XXX")
            //画面の下にToastエラーメッセージを表示
            Toast.makeText(applicationContext, "週間目標が未入力です。", Toast.LENGTH_SHORT).show()
            return false
        }

        if (binding.tvDate.text.toString().length == 0) {
            //日付の入力エリアをフォーカスさせる
            //binding.tvDate.requestFocus()
            //Log.d("[phone]", "XXX")
            //画面の下にToastエラーメッセージを表示
            Toast.makeText(applicationContext, "日付を未選択です。", Toast.LENGTH_SHORT).show()
            return false
        }

        if (binding.tvTimeBefore.text.toString().length == 0) {
            //binding.tvTimeBefore.requestFocus()

            Toast.makeText(applicationContext, "開始時間が未選択です。", Toast.LENGTH_LONG).show()
            return false
        }

        if (binding.tvTimeAfter.text.toString().length == 0) {
            //binding.tvTimeAfter.requestFocus()

            Toast.makeText(applicationContext, "終了時間が未選択です。", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }


}