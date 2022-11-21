package com.maximvs.trackingtravel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maximvs.trackingtravel.App
import com.maximvs.trackingtravel.domain.Interactor
import com.maximvs.trackingtravel.domain.Track

class RouteFragmentViewModel : ViewModel() {
    val tracksListLiveData:  MutableLiveData<List<Track>> = MutableLiveData()
    //Инициализируем интерактор
    private var interactor: Interactor = App.instance.interactor

    init {
        interactor.getTracksFromApi(1, object : ApiCallback {
            override fun onSuccess(tracks: List<Track>) {
                tracksListLiveData.postValue(tracks)
            }

            override fun onFailure() {
            }
        })
    }

    interface ApiCallback {
        fun onSuccess(tracks: List<Track>)
        fun onFailure()
    }
}
