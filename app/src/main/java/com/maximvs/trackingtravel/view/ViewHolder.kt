package com.maximvs.trackingtravel.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maximvs.trackingtravel.domain.Route
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title = itemView.tv_rv_item_title
    private var photo = itemView.photo
    private val duration = itemView.tv_rv_item_1
    private val distanceRoute = itemView.tv_rv_item_2
    private val heightPeak = itemView.tv_rv_item_3

    fun bind(route: Route) {

        title.text = route.title

        Glide.with(itemView)
            .load(route.photos[0].uri)
            .centerCrop()
            .into(photo)

        duration.text = route.duration
        distanceRoute.text = route.distanceRoute
        heightPeak.text = route.heightPeak
    }
}
