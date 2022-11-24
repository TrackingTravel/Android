package com.maximvs.trackingtravel.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maximvs.trackingtravel.data.ApiConstants
import com.maximvs.trackingtravel.domain.Route
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    //Привязываем view из layout к переменным
    private val title = itemView.tv_rv_item_title
    private val photo = itemView.photo
    private val duration = itemView.tv_rv_item_1
    private val distanceRoute = itemView.tv_rv_item_2
    private val heightPeak = itemView.tv_rv_item_3

    fun bind(route: Route) {
        //Устанавливаем заголовок
        title.text = route.title
        //Устанавливаем постер
        //Указываем контейнер, в которм будет "жить" наша картинка
        //TODO Обработать список картинок
//        Glide.with(itemView)
//            //Загружаем сам ресурс
//            .load(ApiConstants.IMAGE_URL + "photo_2022-10-31_00-02-52.jpg")
//            //Центруем изображение
//            .centerCrop()
//            //Указываем ImageView, куда будем загружать изображение
//            .into(photo)
        //Устанавливаем описание
        duration.text = route.duration
        distanceRoute.text = route.distanceRoute
        heightPeak.text = route.heightPeak
    }
}
