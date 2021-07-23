package com.demo.tv_maze.datamodel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country (

   @SerializedName("name") var name : String,
   @SerializedName("code") var code : String,
   @SerializedName("timezone") var timezone : String

): Parcelable