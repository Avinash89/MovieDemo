package com.demo.tv_maze.ui.moviedetail

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.demo.tv_maze.R
import com.google.gson.annotations.Expose


class MovieDetailViewModel(
    context: Context, val showImage: String,
    val showName: String, val showDesc: String
) : ViewModel() {

    var liveShowName: MutableLiveData<String> = MutableLiveData()
    var liveShowDesc: MutableLiveData<String> = MutableLiveData()

    @Expose
    var showImageUrl: String

    init {
        liveShowName.value = showName
        liveShowDesc.value = showDesc
        showImageUrl = showImage;
    }


}

@BindingAdapter("bind:image_url")
fun loadImage(view: ImageView, url: String) {
//        Log.i("III", "Image - $url")
    val context: Context = view.getContext()
    Glide.with(context).load(url).apply(
        RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
    ).into(view)
}