package com.maximvs.trackingtravel.utils

import com.maximvs.trackingtravel.data.Entity.TT_Route
import com.maximvs.trackingtravel.domain.Route

object Converter {
    fun convertApiListToDtoList(list: List<TT_Route>?): List<Route> {
        val result = mutableListOf<Route>()
        list?.forEach {
            result.add(Route(
                title = it.title,
                photo = it.photo,
                description = it.description,

            ))
        }
        return result
    }
}
