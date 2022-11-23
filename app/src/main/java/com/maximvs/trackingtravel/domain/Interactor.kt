package com.maximvs.trackingtravel.domain

import com.maximvs.trackingtravel.data.entity.RoutesWrapper
import com.maximvs.trackingtravel.data.MainRepository
import com.maximvs.trackingtravel.data.TrackingTravelAPI
import com.maximvs.trackingtravel.utils.Converter
import com.maximvs.trackingtravel.viewmodel.RouteFragmentViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Interactor(private val repo: MainRepository, private val retrofitService: TrackingTravelAPI) {
    fun getRoutesFromApi(callback: RouteFragmentViewModel.ApiCallback) {
        retrofitService.getAllRoutes().enqueue(object : Callback<RoutesWrapper> {
            override fun onResponse(call: Call<RoutesWrapper>, response: Response<RoutesWrapper>) {
                callback.onSuccess(Converter.convertApiListToDtoList(response.body()?.routes))
            }

            override fun onFailure(call: Call<RoutesWrapper>, t: Throwable) {
                callback.onFailure()
            }
        })
    }
}
