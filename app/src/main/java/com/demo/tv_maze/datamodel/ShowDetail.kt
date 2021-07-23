package com.demo.tv_maze.datamodel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShowDetail (

   @SerializedName("score") var score : Double,
   @SerializedName("show") var show : Show

) : Parcelable