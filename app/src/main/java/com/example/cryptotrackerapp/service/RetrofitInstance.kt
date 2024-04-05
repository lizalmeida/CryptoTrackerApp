package com.example.cryptotrackerapp.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val BASE_URL = "https://https://0846036a-5930-4668-96fa-668b035d6f54.mock.pstmn.io/v27"

    private val retrofit: Retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val assetsService: AssetsService by lazy{
        retrofit.create(AssetsService::class.java)
    }
}