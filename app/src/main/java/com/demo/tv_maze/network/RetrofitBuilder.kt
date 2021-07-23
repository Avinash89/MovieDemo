package com.demo.tv_maze.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
//    http://api.tvmaze.com/search/shows?q=super
//    private const val BASE_URL = "http://api.tvmaze.com/search/shows?q=super/"
private const val BASE_URL = "https://api.tvmaze.com/search/"
    val gson = GsonBuilder().serializeNulls().create()
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)

}