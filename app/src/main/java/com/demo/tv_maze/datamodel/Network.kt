package com.demo.tv_maze.datamodel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Network (

   @SerializedName("id") var id : Int,
   @SerializedName("name") var name : String,
   @SerializedName("country") var country : Country

): Parcelable