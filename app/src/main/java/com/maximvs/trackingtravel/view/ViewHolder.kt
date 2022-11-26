package com.maximvs.trackingtravel.view

import android.view.View
import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maximvs.trackingtravel.domain.Route
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    //Привязываем view из layout к переменным
    private val title = itemView.tv_rv_item_title
    private val photos = itemView.photo
    private val duration = itemView.tv_rv_item_1
    private val distanceRoute = itemView.tv_rv_item_2
    private val heightPeak = itemView.tv_rv_item_3

    fun bind(route: Route) {
        title.text = route.title

        Glide.with(itemView)
            //Загружаем сам ресурс
            .load(route.photos)
            //Центруем изображение
            .centerCrop()
            //Указываем ImageView, куда будем загружать изображение
            .into(photos)

        duration.text = route.duration
        distanceRoute.text = route.distanceRoute
        heightPeak.text = route.heightPeak
    }
}
