package com.maximvs.trackingtravel.data

import com.maximvs.trackingtravel.data.Entity.TT_Photo
import com.maximvs.trackingtravel.domain.Route

class MainRepository {
    val routesDataBase = listOf(
        Route("Название маршрута", List<TT_Photo>, "Description")

    )
}