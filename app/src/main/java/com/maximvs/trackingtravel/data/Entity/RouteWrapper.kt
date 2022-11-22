package com.maximvs.trackingtravel.data.Entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RouteWrapper(
    @SerializedName("routes")
    val routes: TT_Route

) : Parcelable

