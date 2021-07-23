package com.demo.tv_maze.util;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.demo.tv_maze.network.ApiHelper;
import com.demo.tv_maze.ui.movielist.MainListViewModel;

public class MyViewModelFactory implements ViewModelProvider.Factory {
    private Application mApplication;
    private ApiHelper mApiHelper;


    public MyViewModelFactory(Application application, ApiHelper apiHelper) {
        mApplication = application;
        mApiHelper = apiHelper;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new MainListViewModel(mApiHelper);
    }

}