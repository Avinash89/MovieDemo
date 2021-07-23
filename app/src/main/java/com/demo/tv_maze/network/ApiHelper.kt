package com.demo.tv_maze.network

import com.demo.tv_maze.datamodel.ShowDetail

interface ApiHelper {

    suspend fun getUsers(): List<ShowDetail>

//    suspend fun getMoreUsers(): List<ApiUser>

//    suspend fun getUsersWithError(): List<ApiUser>

}