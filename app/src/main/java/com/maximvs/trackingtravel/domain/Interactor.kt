package com.maximvs.trackingtravel.domain

import com.maximvs.trackingtravel.data.Entity.RoutesWrapper
import com.maximvs.trackingtravel.data.MainRepository
import com.maximvs.trackingtravel.data.TrackingTravelAPI
import com.maximvs.trackingtravel.utils.Converter
import com.maximvs.trackingtravel.viewmodel.RouteFragmentViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Interactor(private val repo: MainRepository, private val retrofitService: TrackingTravelAPI) {
    //В конструктор мы будм передавать коллбэк из вьюмоделе, чтобы реагировать на то, когда маршруты будут получены
    //и страницу, котороую нужно загрузить (это для пагинации)
    fun getRoutesFromApi(page: Int, callback: RouteFragmentViewModel.ApiCallback) {
        retrofitService.getAllRoutes().enqueue(object : Callback<RoutesWrapper> {
            override fun onResponse(call: Call<RoutesWrapper>, response: Response<RoutesWrapper>) {
                //При успехе мы вызываем метод передаем onSuccess и в этот коллбэк список маршрутов
                callback.onSuccess(Converter.convertApiListToDtoList(response.body()?.routes))
            }

            override fun onFailure(call: Call<RoutesWrapper>, t: Throwable) {
                //В случае провала вызываем другой метод коллбека
                callback.onFailure()
            }
        })
    }
}
