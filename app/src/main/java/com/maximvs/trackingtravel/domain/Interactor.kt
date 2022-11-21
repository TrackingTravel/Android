package com.maximvs.trackingtravel.domain

import com.maximvs.trackingtravel.data.Entity.TrTrResultsDTO
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
    fun getTracksFromApi(page: Int, callback: RouteFragmentViewModel.ApiCallback) {
        retrofitService.getTracks(API.KEY, "ru-RU", page).enqueue(object :
            Callback<TrTrResultsDTO> {
            override fun onResponse(call: Call<TrTrResultsDTO>, response: Response<TrTrResultsDTO>) {
                //При успехе мы вызываем метод передаем onSuccess и в этот коллбэк список фильмов
                callback.onSuccess(Converter.convertApiListToDtoList(response.body()?.trTrTracks))
            }

            override fun onFailure(call: Call<TrTrResultsDTO>, t: Throwable) {
                //В случае провала вызываем другой метод коллбека
                callback.onFailure()
            }
        })
    }
}
