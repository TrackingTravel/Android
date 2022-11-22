package com.maximvs.trackingtravel.data

import com.maximvs.trackingtravel.data.Entity.RouteResultsDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TrackingTravelAPI {
    @GET("http://trackingtravel.me:8080/api/test-routes/getAll")
    fun getRoute(
       // @Query("api_key") apiKey: String,
       // @Query("language") language: String,
       // @Query("page") page: Int
    ): Call<RouteResultsDTO>
}
