package com.example.rworksample00026.ui.requestdocuments

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityRequestDocumentsFormFirstBinding
import com.example.rworksample00026.ui.UserViewModel
import com.example.rworksample00026.ui.util.DatePickRequestDocuments
import com.example.rworksample00026.ui.util.ScopedAppActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class RequestDocumentsFormFirstActivity : ScopedAppActivity(), DatePickerDialog.OnDateSetListener {

    private lateinit var binding : ActivityRequestDocumentsFormFirstBinding
    private val viewModel: RequestDocumentsViewModel by viewModels()
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRequestDocumentsFormFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nextPageBtn.setOnClickListener (object: View.OnClickListener {
            override fun onClick(v: View?) {
                val check = validationCheck(binding.name, binding.mailAddress, binding.phoneNumber)
                if (check) {
                    //Log.d("check", "XXX")
                    launch{ withContext(Dispatchers.Default){viewModel.insert(binding.name.text.toString(), binding.phoneticGuides.text.toString(), binding.birthday.text.toString(), binding.mailAddress.text.toString(), binding.phoneNumber.text.toString())} }



                    val intent = Intent(this@RequestDocumentsFormFirstActivity, RequestDocumentsFormSecondActivity::class.java)
                    startActivity(intent)
                }
            }
        })

        binding.adminPageBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@RequestDocumentsFormFirstActivity, RequestDocumentsAdminActivity::class.java)
                startActivity(intent)
            }
        })

    }

    fun validationCheck(name: EditText, mail: EditText, phone: EditText) : Boolean {
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

        if (binding.mailAddress.text.toString().length == 0 && !Patterns.EMAIL_ADDRESS.matcher(mail.text.toString()).matches()){
            //メールアドレスの入力エリアをフォーカスさせる
            binding.mailAddress.requestFocus()
            Log.d("[mail]", "XXX")
            //画面の下にToastエラーメッセージを表示
            Toast.makeText(applicationContext, "メールアドレスが未入力または不正です。", Toast.LENGTH_SHORT).show()
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

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val str = String.format(Locale.US, "%d/%d/%d", year, month+1, dayOfMonth)
        binding.birthday.text = str
    }

    fun showDatePickerDialog(v: View){
        /**
         * 日付入力ボタン押した時カレンダー表示
         */
        val newFragment = DatePickRequestDocuments()
        newFragment.show(supportFragmentManager, "datePicker")
    }
}