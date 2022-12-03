package com.maximvs.trackingtravel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maximvs.trackingtravel.domain.Interactor
import com.maximvs.trackingtravel.domain.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RouteFragmentViewModel @Inject constructor(
    interactor: Interactor
) : ViewModel() {

    val routesListLiveData: MutableLiveData<List<Route>> = MutableLiveData()


    init {
        interactor.getRoutesFromApi(object : ApiCallback {
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
