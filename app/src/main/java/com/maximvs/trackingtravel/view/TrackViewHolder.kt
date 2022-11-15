package com.maximvs.trackingtravel.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.track_item.view.*


class TrackViewHolder (private val itemView: View) : RecyclerView.ViewHolder(itemView){
        private var photo=itemView.photo
        private var title=itemView.title
        private var description=itemView.description


        fun bind(track: Track){
            photo.setImageResource(track.photo)
            title.text=track.title
            description.text=track.description
        }
    }
