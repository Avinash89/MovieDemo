package com.demo.tv_maze.datamodel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Externals (

   @SerializedName("tvrage") var tvrage : String,
   @SerializedName("thetvdb") var thetvdb : Int,
   @SerializedName("imdb") var imdb : String

): Parcelable