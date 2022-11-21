package com.maximvs.trackingtravel.data.Entity

import com.google.gson.annotations.SerializedName

data class TrTrResultsDTO (
        @SerializedName("page")
        val page: Int,
        @SerializedName("results")
        val trTrTracks: List<TrTrTrack>,
        @SerializedName("total_pages")
        val totalPages: Int,
        @SerializedName("total_results")
        val totalResults: Int
    )

