package com.maximvs.trackingtravel.di.modules

import android.content.Context
import androidx.room.Room
import com.maximvs.trackingtravel.data.dao.RouteDao
import com.maximvs.trackingtravel.data.MainRepository
import com.maximvs.trackingtravel.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun provideRouteDao(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "route_db"
        ).build().routeDao()


    @Provides
    @Singleton
    fun provideRepository(routeDao: RouteDao) = MainRepository(routeDao)
}

