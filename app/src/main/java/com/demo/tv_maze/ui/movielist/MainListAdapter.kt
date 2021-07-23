package com.demo.tv_maze.ui.movielist

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.demo.tv_maze.R
import com.demo.tv_maze.datamodel.ShowDetail
import kotlinx.android.synthetic.main.layout_single_item_movie_list.view.*

//class MainListAdapter : RecyclerView.Adapter<MainListAdapter.MainListViewHolder>() {
//
//    private val listOfMovieView: MutableList<ShowDetail> = mutableListOf()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
//        return MainListViewHolder(
//            LayoutInflater.from(parent.context).inflate(
//                R.layout.layout_single_item_movie_list,
//                parent,
//                false
//            )
//        )
//    }
//
//    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
//        holder.bind(listOfMovieView[position])
//    }
//
//    override fun getItemCount(): Int {
//        return listOfMovieView.size
//    }
//
//    inner class MainListViewHolder(private val mView: View) : RecyclerView.ViewHolder(mView) {
//
//        fun bind(showDetail: ShowDetail) {
//            mView.tvMovieName.text = showDetail.show.name
////            mView.tvVotes.text = showDetail.show.voteAverage.toString()
////            mView.ivBookmark.isSelected = showDetail.show.isBookMarked
////            showDetail.show.image.medium?.let {
////                if (it.isNotBlank())
////                    Picasso.get().load(it).into(mView.ivImageView)
//                    Glide.with(mView.context)
//                        .load(Uri.parse(showDetail.show.image.medium))
//                        .apply(
//                            RequestOptions()
//                            .placeholder(R.drawable.ic_launcher_background)
//                            .error(R.drawable.ic_launcher_background)
//                            .centerCrop()
//                            .diskCacheStrategy(DiskCacheStrategy.ALL)).into(mView.ivImageView)
////            }
////            onClicks(showDetail)
//        }
//
////        private fun onClicks(movieView: ShowDetail) {
////            mView.ivBookmark.setOnClickListener {
////                it.isSelected = movieView.isBookMarked.not()
////                movieView.isBookMarked = it.isSelected
////                bookmarkClickedListener?.onBookmarkChanged(movieView)
////            }
////        }
//    }
//
//}



class MainListAdapter(val countries: ArrayList<ShowDetail>) :
    RecyclerView.Adapter<MainListAdapter.ViewHolder>() {

    var onCountryItemClick:((ShowDetail) -> Unit)? = null

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val imgCountry : ImageView = view.ivImageView
        val txtCountryName : TextView = view.tvMovieName

        init {
            view.setOnClickListener {
                onCountryItemClick?.invoke(countries[adapterPosition])
            }
        }

        fun bindView(country: ShowDetail) {
            txtCountryName.text = country.show.name
            country?.show?.image?.medium?.let {
                if (it != null) {
                    Glide.with(view.context)
                        .load(Uri.parse(it))
                        .apply(RequestOptions()
                            .placeholder(R.drawable.ic_launcher_background)
                            .error(R.drawable.ic_launcher_background)
                            .centerCrop()
                            .diskCacheStrategy(DiskCacheStrategy.ALL)).into(imgCountry)
                } else {
                    Glide.with(view.context)
                        .load(Uri.parse("it"))
                        .apply(RequestOptions()
                            .placeholder(R.drawable.ic_launcher_background)
                            .error(R.drawable.ic_launcher_background)
                            .centerCrop()
                            .diskCacheStrategy(DiskCacheStrategy.ALL)).into(imgCountry)
                }
                }

            }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_single_item_movie_list, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countries[position]
        holder.bindView(country)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    fun addData(list: List<ShowDetail>) {
        countries.addAll(list)
    }
}