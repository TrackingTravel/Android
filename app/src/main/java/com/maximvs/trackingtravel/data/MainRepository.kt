package com.maximvs.trackingtravel.data

import com.maximvs.trackingtravel.dao.RouteDao
import com.maximvs.trackingtravel.data.entity.Route
import java.util.concurrent.Executors


class MainRepository
    constructor(
    private val routeDao: RouteDao) {

    fun putToDb(routes: List<Route>) {
        Executors.newSingleThreadExecutor().execute {
            routeDao.insertAll(routes)
        }
    }

    fun getAllFromDB(): List<Route> {
        return routeDao.getCachedRoutes()
    }
}
