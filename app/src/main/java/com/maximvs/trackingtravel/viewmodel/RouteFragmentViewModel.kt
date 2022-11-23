package com.maximvs.trackingtravel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maximvs.trackingtravel.App
import com.maximvs.trackingtravel.domain.Interactor
import com.maximvs.trackingtravel.domain.Route

class RouteFragmentViewModel : ViewModel() {
    val routesListLiveData:  MutableLiveData<List<Route>> = MutableLiveData()
    //Инициализируем интерактор
    private var interactor: Interactor = App.instance.interactor

    init {
        interactor.getRoutesFromApi( object : ApiCallback {
            override fun onSuccess(routes: List<Route>) {
                routesListLiveData.postValue(routes)
            }

            override fun onFailure() {
            }
        })
    }

    interface ApiCallback {
        fun onSuccess(routes: List<Route>)
        fun onFailure()
    }
}
