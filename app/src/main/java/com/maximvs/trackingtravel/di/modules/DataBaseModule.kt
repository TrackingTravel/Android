package com.maximvs.trackingtravel.di.modules

import com.maximvs.trackingtravel.data.MainRepository
import dagger.Module
import dagger.hilt.InstallIn

@Module
@InstallIn
object DataBaseModule {
    fun provideRepository() = MainRepository()
}
