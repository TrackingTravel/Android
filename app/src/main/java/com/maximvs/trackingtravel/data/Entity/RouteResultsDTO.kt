package com.maximvs.trackingtravel.data.Entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RouteResultsDTO (
        @SerializedName("page")
        val page: Int,
        @SerializedName("results")
        val RoutesWrapper: List<TT_Route>,
        @SerializedName("total_pages")
        val totalPages: Int,
        @SerializedName("total_results")
        val totalResults: Int
    ) : Parcelable

