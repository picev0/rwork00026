package com.example.rworksample00026.ui.requestdocuments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.viewModels
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityRequestDocumentsFormThirdBinding
import com.example.rworksample00026.ui.util.ScopedAppActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RequestDocumentsFormThirdActivity : ScopedAppActivity() {

    private lateinit var binding : ActivityRequestDocumentsFormThirdBinding
    private val viewModel: RequestDocumentsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRequestDocumentsFormThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val spinnerDisItems = arrayOf(
            "なし",
            "申請中",
            "あり"
        )

        val spinnerSndItems = arrayOf(
            "郵送を希望する",
            "郵送を希望しない"
        )

        val adapterDis = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item,
            spinnerDisItems
        )

        val adapterSnd = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item,
            spinnerSndItems
        )

        val spinnerDis = binding.spinnerDisableCertificate
        val spinnerSnd = binding.spinnerSendingMaterials
        val ansDis = binding.tvDisableCertificate
        val ansSnd = binding.tvSendingMaterials

        adapterDis.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterSnd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerDis.adapter = adapterDis
        spinnerSnd.adapter = adapterSnd

        //リスナを登録
        spinnerDis.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            // アイテムが選択された時
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String
                ansDis.text = item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(applicationContext, "手帳の有無が未選択です", Toast.LENGTH_LONG)
            }
        }

        // リスナを登録
        spinnerSnd.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {

            // アイテムが選択された時
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String
                ansSnd.text = item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(applicationContext, "資料の送付方法が未選択です", Toast.LENGTH_LONG)
            }
        }

        binding.nextPageBtn.setOnClickListener (object : View.OnClickListener{
            override fun onClick(v: View?) {
                //https://qiita.com/kumamotone/items/8972dc5732a48c90f0dd
                //withContext
                launch{ withContext(Dispatchers.Default){viewModel.updateParam(ansDis.text.toString(), ansSnd.text.toString(), binding.remarks.text.toString())} }


                val intent = Intent(this@RequestDocumentsFormThirdActivity, RequestDocumentsConfirmActivity::class.java)
                startActivity(intent)
            }
        })
    }
}