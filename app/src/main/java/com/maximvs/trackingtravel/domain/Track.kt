package com.maximvs.trackingtravel.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Track(

    val title: String,
    val photo: Int,
    val description: String,
) : Parcelable
