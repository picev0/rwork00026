package com.example.rworksample00026.model.net

import okhttp3.OkHttpClient

object HttpClient {
    /**
     *https://qiita.com/jonghyo/items/bf3e4e06022eebe8e3eb
     * 　okhttp3をシングルトンで使うの部分
     */
    val instance = OkHttpClient()

}