package com.maximvs.trackingtravel.data.Entity

import com.google.gson.annotations.SerializedName

data class TT_Route(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("linkToMap")
    val linkToMap: String,
    @SerializedName("heightPeak")
    val heightPeak: String,
    @SerializedName("distanceRoute")
    val distanceRoute: String,
    @SerializedName("durationRoute")
    val durationRoute: String,
    @SerializedName("mapPhoto")
    val mapPhoto: List<MapPhoto>,
    @SerializedName("photo")
    val photo: List<TT_Photo>,
    @SerializedName("country")
    val country: List<Country>

)



