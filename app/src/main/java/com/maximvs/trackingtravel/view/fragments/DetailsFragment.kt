package com.maximvs.trackingtravel.view.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import com.maximvs.trackingtravel.data.entity.Route
import com.maximvs.trackingtravel.databinding.FragmentDetailsBinding
import com.maximvs.trackingtravel.view.MainActivity
import com.maximvs.trackingtravel.view.adapters.ViewPagerAdapter


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

        setRoutesDetails()

        binding.btnDetailBack.setOnClickListener {
            (activity as MainActivity).removeDetailsFragment()
        }

        //Создаем адаптер
        val pagerAdapter = ViewPagerAdapter()

        //Привязываем созданный адаптер к нашему ViewPager, который у нас в разметке
        binding.viewPager2.adapter = pagerAdapter

        //Создаем список элементов, который передадим в адаптер
        val pagerItems = route.photos

        //Передаем список в адаптер
        pagerAdapter.addItems(pagerItems)

        TabLayoutMediator(binding.fDetTabs, binding.viewPager2) { tab, position ->
            tab.text = "TAB ${(position + 1)}"
        }.attach()
    }

    private fun setRoutesDetails() {
        route = arguments?.get("route") as Route

        binding.tvSearch.text = route.title
        binding.title.text = route.title
        binding.duration.text = route.duration
        binding.distanceRoute.text = route.distanceRoute
        binding.heightPeak.text = route.heightPeak
        binding.description.text = route.description

        Glide.with(this)
            .load(route.mapPhoto[0].uri)
            .centerCrop()
            .into(binding.detMap)

        binding.btnOpenMap.setOnClickListener {
            val geoUri = Uri.parse(route.linkToMap)
            val mapIntent = Intent(Intent.ACTION_VIEW, geoUri)
            startActivity(mapIntent)


        }
    }
}

