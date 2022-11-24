package com.maximvs.trackingtravel.domain

import com.maximvs.trackingtravel.data.entity.RoutesWrapper
import com.maximvs.trackingtravel.data.MainRepository
import com.maximvs.trackingtravel.data.TrackingTravelAPI
import com.maximvs.trackingtravel.data.entity.TT_Route
import com.maximvs.trackingtravel.utils.Converter
import com.maximvs.trackingtravel.viewmodel.RouteFragmentViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Interactor(private val repo: MainRepository, private val retrofitService: TrackingTravelAPI) {
    fun getRoutesFromApi(callback: RouteFragmentViewModel.ApiCallback) {
        retrofitService.getAllRoutes().enqueue(object : Callback<List<TT_Route>> {
            override fun onResponse(call: Call<List<TT_Route>>, response: Response<List<TT_Route>>) {
                callback.onSuccess(Converter.convertApiListToDtoList(response.body()))
            }

            override fun onFailure(call: Call<List<TT_Route>>, t: Throwable) {
                callback.onFailure()
            }
        })
    }
}
