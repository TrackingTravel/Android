package com.maximvs.trackingtravel.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.maximvs.trackingtravel.data.ApiConstants
import com.maximvs.trackingtravel.databinding.FragmentDetailsBinding
import com.maximvs.trackingtravel.domain.Route


class DetailsFragment : Fragment() {

    private lateinit var route: Route
    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRouteDetails()
    }

    private fun setRouteDetails() {
        //Получаем наш route из переданного бандла
        route = arguments?.get("route") as Route
        //Устанавливаем заголовок
        binding.tvDetail.text = route.title
        //Устанавливаем картинку
        Glide.with(this)
            .load(route.photos)
            .centerCrop()
            .into(binding.ivRd1)
         binding.detailsDescription.text = route.description

    }
}
