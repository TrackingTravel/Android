package com.maximvs.trackingtravel.domain

import com.maximvs.trackingtravel.data.MainRepository

class Interactor(val repo: MainRepository,) {
    fun getTracksDB(): List<Track> = repo.tracksDataBase
}
