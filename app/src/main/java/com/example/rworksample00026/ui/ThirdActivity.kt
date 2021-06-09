package com.example.rworksample00026.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rworksample00026.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nextPageBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(p0: View?) {
                val intent = Intent(this@ThirdActivity, MainActivity::class.java)
                startActivity(intent)
            }
        })
    }
}