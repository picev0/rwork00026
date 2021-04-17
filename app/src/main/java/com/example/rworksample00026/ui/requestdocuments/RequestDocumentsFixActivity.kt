package com.example.rworksample00026.ui.requestdocuments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.viewModels
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityRequestDocumentsFixBinding
import com.example.rworksample00026.ui.util.ScopedAppActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RequestDocumentsFixActivity : ScopedAppActivity() {

    private lateinit var binding: ActivityRequestDocumentsFixBinding
    private val viewModel: RequestDocumentsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRequestDocumentsFixBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 非同期で入力値を表示(1件だけ)
        launch (Dispatchers.IO){
            val data = viewModel.personData
            launch (Dispatchers.Main){
                binding.editName.setText( data.map { it.name }[0].toString())
                binding.editPhoneticGuides.setText( data.map { it.phoneticGuides }[0].toString() )
                binding.editBirthday.setText( data.map { it.birthday }[0].toString() )
                binding.editMailAddress.setText(data.map { it.mailAddress }[0].toString() )
                binding.editPhoneNumber.setText(data.map{it.phoneNumber}[0].toString())
                binding.editZipStr.setText(data.map{it.zipStr}[0].toString())
                binding.editPrefecture.setText(data.map{it.prefecture}[0].toString())
                binding.editCity.setText(data.map{it.city}[0].toString())
                binding.editAddress.setText(data.map{it.address}[0].toString())
                binding.editDisableCertificate.setText(data.map{it.disableCertifidate}[0].toString())
                binding.editSendingMaterials.setText(data.map{it.sendingMaterials}[0].toString())
                binding.editRemarks.setText(data.map{it.remarks}[0].toString())
            }
        }
        // edittextを代入
        val name = binding.editName
        val phoneticGuides = binding.editPhoneticGuides
        val birthday = binding.editBirthday
        val mailAddress = binding.editMailAddress
        val phoneNumber = binding.editPhoneNumber
        val zipStr = binding.editZipStr
        val prefecture = binding.editPrefecture
        val city = binding.editCity
        val address = binding.editAddress
        val disableCertificate = binding.editDisableCertificate
        val sendingMaterials = binding.editSendingMaterials
        val remarks = binding.editRemarks
        name.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                //入力されたものを変更(非同期)(これは名前)
                launch{ withContext(Dispatchers.Default){viewModel.updateName(s.toString())} }


            }
        })
        phoneticGuides.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
            //テキスト変更後の処理
            override fun afterTextChanged(s: Editable?) {
                // ふりがなを入力値と変更
                launch{ withContext(Dispatchers.Default){ viewModel.updatePhoneticGuides(s.toString()) } }


            }
        })
        birthday.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                launch{
                    withContext(Dispatchers.Default){ viewModel.updateBirthday(s.toString()) }
                }



            }
        })
        mailAddress.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                launch{ withContext(Dispatchers.Default){ viewModel.updateMailAddress(s.toString()) } }


            }
        })
        phoneNumber.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                launch{
                    withContext(Dispatchers.Default){ viewModel.updatePhoneNumber(s.toString()) }
                }


            }
        })
        zipStr.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                launch{ withContext(Dispatchers.Default){ viewModel.updateZipStr(s.toString()) } }

            }
        })
        prefecture.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                launch{
                    withContext(Dispatchers.Default){ viewModel.updatePrefecture(s.toString()) }
                }


            }
        })
        city.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                launch{ withContext(Dispatchers.Default){ viewModel.updateCity(s.toString()) } }


            }
        })
        address.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                launch{
                    withContext(Dispatchers.Default){ viewModel.updateAddressMod(s.toString()) }
                }


            }
        })
        disableCertificate.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                launch{ withContext(Dispatchers.Default){ viewModel.updateDisableCertificate(s.toString()) } }


            }
        })
        sendingMaterials.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                launch{ withContext(Dispatchers.Default){ viewModel.updateSendingMaterials(s.toString()) } }

            }
        })
        remarks.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                launch{
                    withContext(Dispatchers.Default){ viewModel.updateRemarks(s.toString()) }
                }


            }
        })

        binding.Btn.setOnClickListener (object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@RequestDocumentsFixActivity, RequestDocumentsConfirmActivity::class.java)
                startActivity(intent)
            }
        })

    }
}