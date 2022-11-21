package com.maximvs.trackingtravel.utils

import com.maximvs.trackingtravel.data.Entity.TrTrTrack
import com.maximvs.trackingtravel.domain.Track

object Converter {
    fun convertApiListToDtoList(list: List<TrTrTrack>?): List<Track> {
        val result = mutableListOf<Track>()
        list?.forEach {
            result.add(Track(
               // title = it.title,
               // photo = it.posterPath,
              // description = it.overview,

            ))
        }
        return result
    }
}
