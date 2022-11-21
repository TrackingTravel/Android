package com.maximvs.trackingtravel.data

import com.maximvs.trackingtravel.data.Entity.TrTrResultsDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TrackingTravelAPI {
    @GET("api/test-routes/getAll")
    fun getTracks(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<TrTrResultsDTO>
}
