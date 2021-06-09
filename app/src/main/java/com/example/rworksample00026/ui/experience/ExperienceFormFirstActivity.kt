package com.example.rworksample00026.ui.experience

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityExperienceFormFirstBinding
import com.example.rworksample00026.ui.util.DatePickExperience
import com.example.rworksample00026.ui.util.DatePickRequestDocuments
import com.example.rworksample00026.ui.util.ScopedAppActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class ExperienceFormFirstActivity : ScopedAppActivity(), DatePickerDialog.OnDateSetListener {

    private lateinit var binding: ActivityExperienceFormFirstBinding
    private val viewModel : ExperienceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExperienceFormFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val spinnerApplicationFormItems = arrayOf(
                "見学申込",
                "オンライン見学申込"
        )
        val adapterAppForms = ArrayAdapter(
                applicationContext,
                android.R.layout.simple_spinner_item,
                spinnerApplicationFormItems
        )
        val ansForm = binding.answerApplicationForm

        adapterAppForms.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerApplicationForm.adapter = adapterAppForms

        binding.spinnerApplicationForm.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String
                ansForm.text = item
                //https://kotlin.akira-watson.com/android/spinner.html
                //プルダウンメニュー
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(applicationContext, "お申込み形態が未選択です", Toast.LENGTH_LONG)
            }
        }

        binding.nextPageBtn.setOnClickListener (object : View.OnClickListener{
            override fun onClick(v: View?) {
                val check = validationCheck(binding.name, binding.phoneNumber)
                if (check) {
                    launch { withContext(Dispatchers.Default) { viewModel.insert(binding.answerApplicationForm.text.toString(), binding.name.text.toString(), binding.phoneticGuides.text.toString(), binding.birthday.text.toString(), binding.phoneNumber.text.toString())}}
                    val intent = Intent(this@ExperienceFormFirstActivity, ExperienceFormSecondActivity::class.java)
                    startActivity(intent)
                }
            }
        })
    }

    fun validationCheck(name: EditText, phone: EditText) : Boolean {
        /**
         *
         * バリデーションチェック
         *
         *
         * メールアドレスに@が含まれるか
         */
        if (binding.name.text.toString().length == 0) {
            //名前の入力エリアをフォーカスさせる
            binding.name.requestFocus()
            Log.d("[name]", "XXX")
            //画面の下にToastエラーメッセージを表示
            Toast.makeText(applicationContext, "名前が未入力です。", Toast.LENGTH_SHORT).show()
            return false
        }

        if (binding.phoneNumber.text.toString().length == 0) {
            //電話番号の入力エリアをフォーカスさせる
            binding.phoneNumber.requestFocus()
            Log.d("[phone]", "XXX")
            //画面の下にToastエラーメッセージを表示
            Toast.makeText(applicationContext, "電話番号が未入力です。", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    fun showDatePickerDialog(v: View){
        /**
         * 日付入力ボタン押した時カレンダー表示
         */
        val newFragment = DatePickExperience()
        newFragment.show(supportFragmentManager, "datePicker")
    }

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val str = String.format(Locale.US, "%d/%d/%d", year, month+1, dayOfMonth)
        binding.birthday.text = str
    }
}