package com.maximvs.trackingtravel.data

import com.maximvs.trackingtravel.data.Entity.RoutesWrapper
import retrofit2.Call
import retrofit2.http.GET

interface TrackingTravelAPI {
    @GET("test-routes/getAll")
    fun getAllRoutes(
       // @Query("page") page: Int
    ): Call<RoutesWrapper>
}
