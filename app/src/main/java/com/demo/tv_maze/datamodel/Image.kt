package com.demo.tv_maze.datamodel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image (

   @SerializedName("medium") var medium : String,
   @SerializedName("original") var original : String

): Parcelable