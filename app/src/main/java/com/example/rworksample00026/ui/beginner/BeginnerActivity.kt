package com.example.rworksample00026.ui.beginner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityBeginnerBinding
import com.example.rworksample00026.ui.MainActivity

class BeginnerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBeginnerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBeginnerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.catchTheBall.setOnClickListener (object : View.OnClickListener{
            override fun onClick(p0: View?) {
                val intent = Intent(this@BeginnerActivity, StartActivity::class.java)
                startActivity(intent)
            }
        })

        binding.backBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(p0: View?) {
                val intent = Intent(this@BeginnerActivity, MainActivity::class.java)
                startActivity(intent)
            }
        })
    }
}