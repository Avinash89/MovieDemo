package com.demo.tv_maze.datamodel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Schedule (

   @SerializedName("time") var time : String,
   @SerializedName("days") var days : List<String>

): Parcelable