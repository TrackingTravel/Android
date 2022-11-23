package com.maximvs.trackingtravel.data.entity

import com.google.gson.annotations.SerializedName

data class RoutesWrapper(
    @SerializedName("routes")
    val routes: List<TT_Route>
    )

