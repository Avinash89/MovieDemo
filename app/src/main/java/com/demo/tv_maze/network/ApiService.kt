package com.demo.tv_maze.network

import com.demo.tv_maze.datamodel.ShowDetail
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
//    search/shows?q=super/
    @GET("shows?")
    suspend fun getUsers(@Query("q") q: String): List<ShowDetail>

//    @GET("more-users")
//    suspend fun getMoreUsers(): List<ApiUser>

//    @GET("error")
//    suspend fun getUsersWithError(): List<ApiUser>

}