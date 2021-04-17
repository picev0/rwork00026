package com.example.rworksample00026.model.net

import okhttp3.Request

class Http {
    /***
     *  https://qiita.com/jonghyo/items/bf3e4e06022eebe8e3eb
     *  val http = Http()の呼び出し
     */
    fun httpGet(url: String): String? {
        val request = Request.Builder()
            .url(url)
            .build()
        val response = HttpClient.instance.newCall(request).execute()
        val body = response.body?.string()
        return body
    }
}