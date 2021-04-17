package com.example.rworksample00026.ui.util

import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

open class ScopedAppActivity: AppCompatActivity(), CoroutineScope by MainScope() {
    //https://101010.fun/programming/android-kotlin-coroutine.html
    //onDestroyでコルーチンのJobキャンセルし忘れがなくなり、記述も簡潔に書けるようになる
    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }
}