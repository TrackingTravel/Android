package com.maximvs.trackingtravel.view

import android.location.GnssAntennaInfo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maximvs.trackingtravel.R

//в параметр передаю слушатель, чтобы потом обрабатывать нажатия из класса Activity
class MyAdapter(private val listener: GnssAntennaInfo.Listener): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView
    }

    override fun getItemCount(): Int {
        return 10
    }
}


