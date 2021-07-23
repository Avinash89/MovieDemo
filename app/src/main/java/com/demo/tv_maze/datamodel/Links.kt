package com.demo.tv_maze.datamodel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Links (

   @SerializedName("self") var self : Self,
   @SerializedName("previousepisode") var previousepisode : Previousepisode,
   @SerializedName("nextepisode") var nextepisode : Nextepisode

): Parcelable