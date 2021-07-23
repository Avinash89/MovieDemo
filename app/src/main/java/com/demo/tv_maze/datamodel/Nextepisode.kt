package com.demo.tv_maze.datamodel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Nextepisode (

   @SerializedName("href") var href : String

): Parcelable