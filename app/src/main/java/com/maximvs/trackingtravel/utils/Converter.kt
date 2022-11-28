package com.maximvs.trackingtravel.utils

import com.maximvs.trackingtravel.data.entity.MapPhoto
import com.maximvs.trackingtravel.data.entity.TT_Route
import com.maximvs.trackingtravel.domain.Route

object Converter {

    fun convertApiListToDtoList(list: List<TT_Route>?): List<Route> {
        val result = mutableListOf<Route>()
        list?.forEach {
            result.add(
                Route(
                    title = it.title,
                    photos = it.photo,
                    duration = it.durationRoute,
                    distanceRoute = it.distanceRoute,
                    heightPeak = it.heightPeak,
                    id = it.id,
                    description = it.description,
                    linkToMap = it.linkToMap,
                    mapPhoto = it.mapPhoto,
                    country = it.country

                )
            )
        }
        return result
    }
}
