package com.example.rworksample00026.ui.beginner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val scoreLabel = binding.scoreLabel
        val highScoreLabel = binding.highScoreLabel
        val score = intent.getIntExtra("SCORE", 0)
        scoreLabel.text = score.toString() + ""
        val sharedPreferences = getSharedPreferences("GAME_DATA", MODE_PRIVATE)
        val highScore = sharedPreferences.getInt("HIGH_SCORE", 0)
        if (score > highScore) {
            highScoreLabel.text = "High Score : $score"
            val editor = sharedPreferences.edit()
            editor.putInt("HIGH_SCORE", score)
            editor.apply()
        } else {
            highScoreLabel.text = "High Score : $highScore"
        }
    }

    fun tryAgain(view: View?) {
        startActivity(Intent(applicationContext, CatchtheBallActivity::class.java))
    }

    fun menu(v: View?){
        startActivity(Intent(applicationContext, BeginnerActivity::class.java))
    }

    override fun onBackPressed() {}
}