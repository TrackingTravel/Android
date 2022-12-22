package com.maximvs.trackingtravel.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.maximvs.trackingtravel.data.dao.RouteDao
import com.maximvs.trackingtravel.data.entity.ConverterRoom
import com.maximvs.trackingtravel.data.entity.Route


@TypeConverters(ConverterRoom::class)

@Database(entities = [Route::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun routeDao(): RouteDao


}
