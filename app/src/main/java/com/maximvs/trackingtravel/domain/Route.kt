package com.maximvs.trackingtravel.domain

import android.os.Parcelable
import com.maximvs.trackingtravel.data.entity.Country
import com.maximvs.trackingtravel.data.entity.MapPhoto
import com.maximvs.trackingtravel.data.entity.TT_Photo
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Route(
    val id: Int,
    val title: String,
    val description: String,
    val linkToMap: String,
    val heightPeak: String,
    val distanceRoute: String,
    val duration: String,
    val mapPhoto: List<MapPhoto>,
    val photos: List<TT_Photo>,
    val country: Country

) : Parcelable
