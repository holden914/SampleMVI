package com.example.samplemvi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(JSONPlaceholderApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val jsonPlaceholderApi: JSONPlaceholderApi by lazy {
        retrofit.create(JSONPlaceholderApi::class.java)
    }
}