package com.example.rworksample00026.ui.util

import android.content.Context
import android.media.AudioManager
import android.media.SoundPool
import com.example.rworksample00026.R

class SoundPlayer(context: Context?){
    fun playHitSound() {
        soundPool.play(hitSound, 1.0f, 1.0f, 1, 0, 1.0f)
    }

    fun playOverSound() {
        soundPool.play(overSound, 1.0f, 1.0f, 1, 0, 1.0f)
    }

    companion object {
        private lateinit var soundPool: SoundPool
        private var hitSound: Int = 0
        private var overSound: Int = 0
    }

    init {
        //https://www.tam-music.com/
        //フリー音源
        //https://www.tam-music.com/interface
        //フリー音源・規約
        soundPool = SoundPool(2, AudioManager.STREAM_MUSIC, 0)
        hitSound = soundPool.load(context, R.raw.get1, 1)
        overSound = soundPool.load(context, R.raw.bigshot01, 1)
    }
}