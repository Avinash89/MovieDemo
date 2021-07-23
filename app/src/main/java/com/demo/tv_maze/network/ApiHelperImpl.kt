package com.demo.tv_maze.network

class ApiHelperImpl(private val apiService: ApiService, val q: String) : ApiHelper {

    override suspend fun getUsers() = apiService.getUsers(q)

//    override suspend fun getMoreUsers() = apiService.getMoreUsers()

//    override suspend fun getUsersWithError() = apiService.getUsersWithError()

}