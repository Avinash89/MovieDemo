package com.demo.tv_maze.ui.moviedetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.demo.tv_maze.R
import com.demo.tv_maze.databinding.ActivityMovieDetailBinding


class MovieDetailActivity : AppCompatActivity() {

    //    private lateinit var viewModel: MovieDetailViewModel
    lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

//        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
//            @NonNull
//            override fun <T : ViewModel?> create(@NonNull modelClass: Class<T>): T {
//                return MovieDetailViewModel(
//                    "My string!"
//                ) as T
//            }
//        }
//        viewModel = ViewModelProvider(this, factory)).get(MovieDetailViewModel::class.java)
//        viewModel = ViewModelProviders.of(this, factory).get(MyAndroidViewModel::class.java)
        val showImage: String = intent.getStringExtra("KEY_SHOW_IMAGE").toString()
        val showName: String = intent.getStringExtra("KEY_SHOW_NAME").toString()
        val showDesc: String = intent.getStringExtra("KEY_SHOW_DESC").toString()
        var factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MovieDetailViewModel(this@MovieDetailActivity, showImage, showName,
                showDesc) as T
            }
        }
        val viewModel: MovieDetailViewModel by lazy {
            ViewModelProvider(this, factory).get(MovieDetailViewModel::class.java)
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail)
        binding.lifecycleOwner = this
        binding.movieDetailViewModel = viewModel
//        viewModel = ViewModelProvider(this, factory)).get(MovieDetailViewModel::class.java)
    }
}