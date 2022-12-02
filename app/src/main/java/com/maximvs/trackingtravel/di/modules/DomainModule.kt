package com.maximvs.trackingtravel.di.modules

import com.maximvs.trackingtravel.data.MainRepository
import com.maximvs.trackingtravel.data.TrackingTravelAPI
import com.maximvs.trackingtravel.domain.Interactor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

@Module
@InstallIn
object DomainModule {

    @Provides
    fun provideInteractor(repository: MainRepository, travelAPI: TrackingTravelAPI) = Interactor(repo = repository, retrofitService = travelAPI)
}

