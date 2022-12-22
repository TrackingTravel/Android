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
import com.maximvs.trackingtravel.R
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

        val pagerAdapter = ViewPagerAdapter()

        binding.viewPager2.adapter = pagerAdapter

        val pagerItems = route.photos

        pagerAdapter.addItems(pagerItems)

        TabLayoutMediator(binding.fDetTabs, binding.viewPager2) { tab, position ->
            tab.text = "TAB ${(position + 1)}"
        }.attach()

        binding.detailsFabFavorites.setOnClickListener {
            if (!route.isInFavorites) {
                binding.detailsFabFavorites.setImageResource(R.drawable.ic_baseline_favorite_24)
                route.isInFavorites = true
            } else {
                binding.detailsFabFavorites.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                route.isInFavorites = false
            }
        }
    }

    private fun setRoutesDetails() {
        route = arguments?.get("route") as Route

        binding.detailsFabFavorites.setImageResource(
            if (route.isInFavorites) R.drawable.ic_baseline_favorite_24
            else R.drawable.ic_baseline_favorite_border_24
        )

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













