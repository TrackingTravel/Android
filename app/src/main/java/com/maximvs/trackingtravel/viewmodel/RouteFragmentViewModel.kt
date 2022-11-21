package com.maximvs.trackingtravel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maximvs.trackingtravel.domain.Interactor
import com.maximvs.trackingtravel.domain.Track

class RouteFragmentViewModel : ViewModel() {
    val tracksListLiveData = MutableLiveData<List<Track>>()
    private lateinit var interactor: Interactor
    init {
        val tracks = interactor.getTracksDB()
        tracksListLiveData.postValue(tracks)
    }
}