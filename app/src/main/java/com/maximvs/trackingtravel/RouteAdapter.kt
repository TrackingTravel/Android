package com.maximvs.trackingtravel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maximvs.trackingtravel.databinding.RecyclerviewItemBinding


class RouteAdapter(private val listener: Listener): RecyclerView.Adapter<RouteAdapter.RouteViewHolder>() {

    private var routeList = mutableListOf<Data>()

    class RouteViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = RecyclerviewItemBinding.bind(item)


        fun bind(way: Data, listener: Listener) = with(binding) {
            tvRvItemTitle.text = way.title
            tvRvItem3.text = way.heightPeak
            tvRvItem2.text = way.distanceRoute
            tvRvItem1.text = way.durationRoute

            Glide
                .with(itemView.context) //передается контекст из айтемвью
                .load("http://trackingtravel.me:8080/dowland/photo/photo_2022-10-31_00-02-52.jpg") //Указываем, что будем загружать
                .centerCrop() //Масштабируем с учетом пропорций и отрезаем все, что не влезло
                //.placeholder(R.drawable.ic_round_loop_24)//Картинка, которая будет отображаться, пока картинка не загрузится
                //.error(R.drawable.ic_round_mobiledata_off_24)//Картинка, которая будет показана в случае ошибки загрузки
                .into(poster) //Указываем, куда будем загружать

            poster.setOnClickListener {
                listener.onClick(way)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RouteViewHolder {
        return RouteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false))
    }

    override fun onBindViewHolder(holder: RouteViewHolder, position: Int) {
        holder.bind(routeList[position], listener)
    }

    override fun getItemCount(): Int {
        return routeList.size
    }

    fun addData(way: List<Data>){
        routeList = way.toMutableList()
        notifyDataSetChanged()
    }

    interface Listener {
        fun onClick (way: Data)
    }
}
