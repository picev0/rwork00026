package com.example.rworksample00026.ui.experience

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityExperienceFormConfirmBinding
import com.example.rworksample00026.databinding.ActivityRequestDocumentsConfirmBinding
import java.lang.StringBuilder

class ExperienceFormConfirmActivity : AppCompatActivity() {

    private lateinit var binding : ActivityExperienceFormConfirmBinding
    private val viewModel: ExperienceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExperienceFormConfirmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = viewModel.personData
        val str = StringBuilder()
        for (i in 0 until list.count()){
            str.append("お名前：　")
            str.append(list.map{it.name}[i].toString())
            str.append("\n")
            str.append("ふりがな：　")
            str.append(list.map{it.phoneticGuides}[i].toString())
            str.append("\n")
            str.append("生年月日：　")
            str.append(list.map{it.birthday}[i].toString())
            str.append("\n")
            str.append("メールアドレス：　")
            str.append(list.map {it.mailAddress}[i].toString())
            str.append("\n")
            str.append("電話番号：　")
            str.append(list.map{it.phoneNumber}[i].toString())
            str.append("\n")
            str.append("郵便番号：　")
            str.append(list.map{it.zipStr}[i].toString())
            str.append("\n")
            str.append("住所／都道府県")
            str.append(list.map{it.prefecture}[i].toString())
            str.append("\n")
            str.append("市区町村")
            str.append(list.map{it.city}[i].toString())
            str.append("\n")
            str.append("丁目・番地")
            str.append(list.map{it.address}[i].toString())
            str.append("\n")
            str.append("障害者手帳の有無")
            str.append(list.map{it.disableCertifidate}[i].toString())
            str.append("\n")
            str.append("希望日(第一候補)")
            str.append(list.map{it.desiredDateFirstCandidate}[i].toString())
            str.append("\n")
            str.append("希望日(第二候補)")
            str.append(list.map{it.desiredDateSecondCandidate}[i].toString())
            str.append("\n")
            str.append("希望日(第三候補)")
            str.append(list.map{it.desiredDateThirdCandidate}[i].toString())
            str.append("\n")
            str.append("備考")
            str.append(list.map{it.remarks}[i].toString())
            str.append("\n")

        }
        binding.textView.text = str.toString()

        //val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        //val listView : ListView = binding.listView
        //listView.adapter = adapter

        binding.Btn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@ExperienceFormConfirmActivity, ExperienceFormFixActivity::class.java)
                startActivity(intent)
            }
        })

        binding.submitConfirm.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@ExperienceFormConfirmActivity, ExperienceSendConfirmActivity::class.java)
                startActivity(intent)
            }
        })

    }
}