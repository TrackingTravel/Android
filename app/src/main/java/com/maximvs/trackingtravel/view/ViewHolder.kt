package com.maximvs.trackingtravel.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.maximvs.MyAdapter
import com.maximvs.trackingtravel.domain.Route
import kotlinx.android.synthetic.main.fragment_details.view.*

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //Привязываем view из layout к переменным
        private val title = itemView.tv_detail
        private val photo = itemView.tv_det_photo
        private val description = itemView.tv_details_more


        //В этом методе кладем данные из route в наши view
        fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
            holder.itemView
        }

}
