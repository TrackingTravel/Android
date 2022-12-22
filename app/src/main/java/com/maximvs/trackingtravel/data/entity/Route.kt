package com.maximvs.trackingtravel.data.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "cached_routes", indices = [Index(value = ["title"], unique = true)])

data class Route(
    @PrimaryKey(autoGenerate = true) val idRoute: Int = 0,
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "title")val title: String,
    @ColumnInfo(name = "description")val description: String,
    @ColumnInfo(name = "linkToMap")val linkToMap: String,
    @ColumnInfo(name = "heightPeak")val heightPeak: String,
    @ColumnInfo(name = "distanceRoute")val distanceRoute: String,
    @ColumnInfo(name = "duration")val duration: String,
    @ColumnInfo(name = "mapPhoto")val mapPhoto: List<MapPhoto>,
    @ColumnInfo(name = "photos")val photos: List<TT_Photo>,
    @ColumnInfo(name = "country")val country: Country,
    var isInFavorites: Boolean = false

) : Parcelable
