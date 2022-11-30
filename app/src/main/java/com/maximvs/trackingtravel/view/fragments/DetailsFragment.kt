package com.maximvs.trackingtravel.view.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.maximvs.trackingtravel.databinding.FragmentDetailsBinding
import com.maximvs.trackingtravel.domain.Route
import kotlinx.android.synthetic.main.fragment_details.*


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
    }

    private fun setRoutesDetails() {
       route = arguments?.get("route") as Route

        binding.search.text = route.title
        binding.title.text = route.title

        Glide.with(this)
            .load(route.photos[0].uri)
            .centerCrop()
            .into(iv_rd_1)

        binding.duration.text = route.duration
        binding.distanceRoute.text =route.distanceRoute
        binding.heightPeak.text = route.heightPeak
        binding.description.text = route.description

        Glide.with(this)
            .load(route.mapPhoto[0].uri)
            .centerCrop()
            .into(det_map)

        binding.btnOpenMap.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            Uri.parse(route.linkToMap)


        }


    }
}
