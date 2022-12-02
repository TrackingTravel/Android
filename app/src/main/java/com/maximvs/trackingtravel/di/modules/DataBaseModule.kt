package com.maximvs.trackingtravel.di.modules

import com.maximvs.trackingtravel.data.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    fun provideRepository() = MainRepository()
}
