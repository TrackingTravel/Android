package com.maximvs.trackingtravel.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maximvs.trackingtravel.data.ApiConstants
import com.maximvs.trackingtravel.domain.Track

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //Привязываем view из layout к переменным
        private val title = itemView.title
        private val photo = itemView.photo
        private val description = itemView.description


        //В этом методе кладем данные из track в наши view
        fun bind(track: Track) {
            //Устанавливаем заголовок
            title.text = track.title

            //Устанавливаем постер
            //Указываем контейнер, в которм будет "жить" наша картинка
            Glide.with(itemView)
                //Загружаем сам ресурс
                .load(ApiConstants.IMAGES_URL  + track.photo)
                //Центруем изображение
                .centerCrop()
                //Указываем ImageView, куда будем загружать изображение
                .into(photo)
            //Устанавливаем описание
            description.text = track.description
        }
    }
