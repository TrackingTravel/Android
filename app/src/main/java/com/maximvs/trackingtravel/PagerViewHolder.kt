package com.maximvs.trackingtravel

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maximvs.trackingtravel.data.entity.TT_Photo
import com.maximvs.trackingtravel.databinding.ItemViewPagerBinding

class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    //В этом методе мы передаем данные из TT_Photo в нашу верстку item.xml
    fun bind(item: TT_Photo) {

        Glide
            .with(itemView.context) //передается контекст из айтемвью
            .load(route.photos.url) //Указываем, что будем загружать
            .centerCrop() //Масштабируем с учетом пропорций и отрезаем все, что не влезло
            .into(iv_image) //Указываем, куда будем загружать
    }
}