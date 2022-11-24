package com.maximvs.trackingtravel.data

import com.maximvs.trackingtravel.data.entity.RoutesWrapper
import com.maximvs.trackingtravel.data.entity.TT_Route
import retrofit2.Call
import retrofit2.http.GET

interface TrackingTravelAPI {
    @GET("test-routes/getAll")
    fun getAllRoutes(
        // @Query("page") page: Int
    ): Call<List<TT_Route>>
}
