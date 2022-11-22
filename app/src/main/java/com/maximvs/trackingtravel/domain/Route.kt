package com.maximvs.trackingtravel.domain

import android.os.Parcelable
import com.maximvs.trackingtravel.data.Entity.TT_Photo
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Route(

    val title: String,
    val photo: List<TT_Photo>,
    val description: String,
) : Parcelable
