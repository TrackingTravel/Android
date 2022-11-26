package com.maximvs.trackingtravel.data.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MapPhoto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("uri")
    val uri: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("size")
    val size: Int
) : Parcelable




