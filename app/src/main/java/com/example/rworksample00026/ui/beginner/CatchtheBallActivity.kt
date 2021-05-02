package com.example.rworksample00026.ui.beginner

import android.content.Intent
import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityCatchtheBallBinding
import com.example.rworksample00026.ui.util.SoundPlayer
import java.util.*

class CatchtheBallActivity : AppCompatActivity() {

    private var scoreLabel: TextView? = null
    private var startLabel: TextView? = null
    private var circle: ImageView? = null
    private var orange: ImageView? = null
    private var pink: ImageView? = null
    private var yellow: ImageView? = null

    // サイズ
    private var frameHeight = 0
    private var circleSize = 0
    private var screenWidth = 0
    private var screenHeight = 0

    //位置
    private var circleY = 0f
    private var orangeX = 0f
    private var orangeY = 0f
    private var pinkX = 0f
    private var pinkY = 0f
    private var yellowX = 0f
    private var yellowY = 0f

    // スピード
    private var circleSpeed = 0
    private var orangeSpeed = 0
    private var pinkSpeed = 0
    private var yellowSpeed = 0

    // Score
    private var score = 0

    // Handler & Timer
    private val handler = Handler()
    private var timer: Timer? = Timer()

    // Status
    private var action_flg = false
    private var start_flg = false

    // Sound
    private var soundPlayer: SoundPlayer? = null

    private lateinit var binding: ActivityCatchtheBallBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatchtheBallBinding.inflate(layoutInflater)
        setContentView(binding.root)

        soundPlayer = SoundPlayer(this)
        scoreLabel = findViewById(R.id.scoreLabel)
        startLabel = findViewById(R.id.startLabel)
        circle = findViewById(R.id.circle)
        orange = findViewById(R.id.orange)
        pink = findViewById(R.id.pink)
        yellow = findViewById(R.id.yellow)

        // Screen Size
        val wm = windowManager
        val display = wm.defaultDisplay
        val size = Point()
        display.getSize(size)
        screenWidth = size.x
        screenHeight = size.y
        circleSpeed = Math.round(screenHeight / 60f)
        orangeSpeed = Math.round(screenWidth / 60f)
        pinkSpeed = Math.round(screenWidth / 36f)
        yellowSpeed = Math.round(screenWidth / 45f)
        orange?.setX(-80.0f)
        orange?.setY(-80.0f)
        pink?.setX(-80.0f)
        pink?.setY(-80.0f)
        yellow?.setX(-80.0f)
        yellow?.setY(-80.0f)
        scoreLabel?.setText("Score : 0")
    }

    fun changePos() {
        hitCheck()

        // Orange
        orangeX -= orangeSpeed.toFloat()
        if (orangeX < 0) {
            orangeX = (screenWidth + 20).toFloat()
            orangeY = Math.floor(Math.random() * (frameHeight - orange!!.height)).toFloat()
        }
        orange!!.x = orangeX
        orange!!.y = orangeY

        // Black
        yellowX -= yellowSpeed.toFloat()
        if (yellowX < 0) {
            yellowX = (screenWidth + 10).toFloat()
            yellowY = Math.floor(Math.random() * (frameHeight - circle!!.height)).toFloat()
        }
        yellow!!.x = yellowX
        yellow!!.y = yellowY


        // Pink
        pinkX -= pinkSpeed.toFloat()
        if (pinkX < 0) {
            pinkX = (screenWidth + 5000).toFloat()
            pinkY = Math.floor(Math.random() * (frameHeight - pink!!.height)).toFloat()
        }
        pink!!.x = pinkX
        pink!!.y = pinkY

        // Box
        if (action_flg) {
            circleY -= circleSpeed.toFloat()
        } else {
            circleY += circleSpeed.toFloat()
        }
        if (circleY < 0) circleY = 0f
        if (circleY > frameHeight - circleSize) circleY = (frameHeight - circleSize).toFloat()
        circle!!.y = circleY
        scoreLabel!!.text = "Score : $score"
    }

    fun hitCheck() {
        // Orange
        val orangeCenterX = orangeX + orange!!.width / 2
        val orangeCenterY = orangeY + orange!!.height / 2
        if (hitStatus(orangeCenterX, orangeCenterY)) {
            orangeX = -10.0f
            score += 10
            soundPlayer!!.playHitSound()
        }

        // Pink
        val pinkCenterX = pinkX + pink!!.width / 2
        val pinkCenterY = pinkY + pink!!.height / 2
        if (hitStatus(pinkCenterX, pinkCenterY)) {
            pinkX = -10.0f
            score += 30
            soundPlayer!!.playHitSound()
        }

        // Black
        val yellowCenterX = yellowX + yellow!!.width / 2
        val yellowCenterY = yellowY + yellow!!.height / 2
        if (hitStatus(yellowCenterX, yellowCenterY)) {

            // Game Over!
            if (timer != null) {
                timer!!.cancel()
                timer = null
                soundPlayer!!.playOverSound()
            }

            // 結果画面へ
            val intent = Intent(applicationContext, ResultActivity::class.java)
            intent.putExtra("SCORE", score)
            startActivity(intent)
        }
    }

    fun hitStatus(centerX: Float, centerY: Float): Boolean {
        return if (0 <= centerX && centerX <= circleSize && circleY <= centerY && centerY <= circleY + circleSize) true else false
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (start_flg == false) {
            start_flg = true
            val frame = findViewById<FrameLayout>(R.id.frame)
            frameHeight = frame.height
            circleY = circle!!.y
            circleSize = circle!!.height
            startLabel!!.visibility = View.GONE
            timer!!.schedule(object : TimerTask() {
                override fun run() {
                    handler.post { changePos() }
                }
            }, 0, 20)
        } else {
            if (event.action == MotionEvent.ACTION_DOWN) {
                action_flg = true
            } else if (event.action == MotionEvent.ACTION_UP) {
                action_flg = false
            }
        }
        return true
    }

    override fun onBackPressed() {}
}