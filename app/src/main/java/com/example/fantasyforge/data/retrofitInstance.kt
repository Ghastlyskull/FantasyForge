package com.example.fantasyforge.data

import com.example.fantasyforge.network.DnD5eApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://www.dnd5eapi.co/api/"

    val api: DnD5eApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DnD5eApiService::class.java)
    }
}