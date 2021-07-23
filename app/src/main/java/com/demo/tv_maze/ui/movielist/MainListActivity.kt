package com.demo.tv_maze.ui.movielist

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.tv_maze.R
import com.demo.tv_maze.datamodel.ShowDetail
import com.demo.tv_maze.network.ApiHelperImpl
import com.demo.tv_maze.network.RetrofitBuilder
import com.demo.tv_maze.ui.moviedetail.MovieDetailActivity
import com.demo.tv_maze.util.MyViewModelFactory
import com.demo.tv_maze.util.Status
import kotlinx.android.synthetic.main.activity_mainlist.*


//import androidx.lifecycle.ViewModelProviders

class MainListActivity : AppCompatActivity() {

    private lateinit var countriesAdapter: MainListAdapter
    private var listOfCountries = ArrayList<ShowDetail>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: MainListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainlist)

        recyclerView = movieListRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        countriesAdapter = MainListAdapter(listOfCountries)
        recyclerView.adapter = countriesAdapter

        countriesAdapter.onCountryItemClick = { it ->
            val intent = Intent(this, MovieDetailActivity::class.java)
            intent.putExtra("KEY_SHOW_IMAGE", it?.show?.image?.original)
            intent.putExtra("KEY_SHOW_NAME", it.show.name)
            intent.putExtra("KEY_SHOW_DESC", it.show.summary)
            startActivity(intent)
        }
        setupViewModel()
        setupObserver()
    }

    private fun setupViewModel() {
//        viewModel = ViewModelProviders.of(
//            this, ViewModelFactory(
//                ApiHelperImpl(RetrofitBuilder.apiService),
//                DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext))
//            )
//        ).get(MainListViewModel::class.java)

//        viewModel = ViewModelProvider(this).get(MainListViewModel::class.java)
        viewModel = ViewModelProvider(this, MyViewModelFactory(this.application,
            ApiHelperImpl(RetrofitBuilder.apiService, "super"))).get(MainListViewModel::class.java)
    }

    private fun setupObserver() {
        viewModel.getUsers().observe(this, {
            when (it.status) {
                Status.SUCCESS -> {
//                    progressBar.visibility = View.GONE
                    it.data?.let { users -> renderList(users) }
                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
//                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
//                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(users: List<ShowDetail>) {
        countriesAdapter.addData(users)
        countriesAdapter.notifyDataSetChanged()
    }
}