package com.maximvs.trackingtravel

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("api/test-routes/getAll")
    fun getUsers(): Call<UsersData>
}