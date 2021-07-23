package com.demo.tv_maze.ui.movielist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.tv_maze.datamodel.ShowDetail
import com.demo.tv_maze.util.Resource
import androidx.lifecycle.viewModelScope
import com.demo.tv_maze.network.ApiHelper
import kotlinx.coroutines.launch

class MainListViewModel(private val apiHelper: ApiHelper) : ViewModel() {

    private val users = MutableLiveData<Resource<List<ShowDetail>>>()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            users.postValue(Resource.loading(null))
            try {
                val usersFromApi = apiHelper.getUsers()
                users.postValue(Resource.success(usersFromApi))
            } catch (e: Exception) {
                users.postValue(Resource.error(e.toString(), null))
            }
        }
    }

    fun getUsers(): LiveData<Resource<List<ShowDetail>>> {
        return users
    }

}