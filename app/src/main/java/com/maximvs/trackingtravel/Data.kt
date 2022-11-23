package com.maximvs.trackingtravel

data class Data(
    val id: Int,
    val title: String,
    val description: String,
    val heightPeak: String,
    val distanceRoute: String,
    val durationRoute: String,
    val mapPhoto: String,
    val photo: List<String>

)
