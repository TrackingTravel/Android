package com.maximvs.trackingtravel.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maximvs.trackingtravel.R
import com.maximvs.trackingtravel.data.entity.TT_Photo
import com.maximvs.trackingtravel.view.viewHolders.PagerViewHolder

class ViewPagerAdapter : RecyclerView.Adapter<PagerViewHolder>() {
    //Здесь хранится список наших объектов с цветом и текстом
    private val items = mutableListOf<TT_Photo>()

    //Этот метод мы возвращает количество элементов в items, иногда полезно
    override fun getItemCount(): Int = items.size

    //В это методе создается VIewHolder и к нему привязывается наш item.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder =
        PagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false))

    //В это методы передаются данные из items в layout
    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    //Этот метод наполняет список items, нужен нам чтобы делать это извне
    fun addItems(list: List<TT_Photo>) {
        items.clear()
        items.addAll(list)
    }
}



