package com.example.rworksample00026.ui.experience

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.eclipsesource.json.Json
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityExperienceFormSecondBinding
import com.example.rworksample00026.model.net.Http
import com.example.rworksample00026.ui.UserViewModel
import com.example.rworksample00026.ui.requestdocuments.RequestDocumentsFormThirdActivity
import com.example.rworksample00026.ui.util.ScopedAppActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.UnsupportedOperationException

class ExperienceFormSecondActivity : ScopedAppActivity() {

    private lateinit var binding: ActivityExperienceFormSecondBinding
    private val viewModel: ExperienceViewModel by viewModels()
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExperienceFormSecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        EditTextChange()

        //http://android.techblog.jp/archives/9614747.html

        binding.button.setOnClickListener (object : View.OnClickListener {
            override fun onClick(v: View?) {
                val zipCode = binding.editText
                val URL = "http://zipcloud.ibsnet.co.jp/api/search?zipcode=${zipCode.getText()}"
                getAddress(URL)
            }
        })

        binding.nextPageBtn.setOnClickListener (object : View.OnClickListener{
            override fun onClick(v: View?) {
                launch{ withContext(Dispatchers.Default){viewModel.updateAddress(binding.zipText.text.toString(), binding.prefecture.text.toString(), binding.city.text.toString(), binding.address.text.toString())} }

                val intent = Intent(this@ExperienceFormSecondActivity, ExperienceFormThirdActivity::class.java)
                startActivity(intent)
            }
        })

    }

    fun EditTextChange() {
        /**
         * https://qiita.com/oda3104/items/4dc2ce5f9a0f4254ebda
         */
        val getZipcode = binding.editText
        getZipcode.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //テキスト変更後前の処理
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // テキスト変更中の処理
            }

            override fun afterTextChanged(s: Editable?) {
                // テキスト変更後の処理
                val zipText = binding.zipText
                zipText.setText(s.toString())
            }
        })
    }

    fun getAddress(URL: String) = launch (Dispatchers.Main){
        /**
         * https://qiita.com/oda3104/items/4dc2ce5f9a0f4254ebda
         */
        val http = Http()
        try {
            async (Dispatchers.Default) {
                http.httpGet(URL)
            }.await().let {
                Log.d("[ERROR]","XXX")
                val result = Json.parse(it).asObject()
                val prefecture = binding.prefecture
                val city = binding.city
                val address = binding.address
                prefecture.setText(result.get("results").asArray()[0].asObject().get("address1").asString())
                city.setText(result.get("results").asArray()[0].asObject().get("address2").asString())
                address.setText(result.get("results").asArray()[0].asObject().get("address3").asString())
            }
        } catch (e: UnsupportedOperationException) {
            Log.d("[ERROR]", e.toString())
        }
    }
}