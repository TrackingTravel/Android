package com.maximvs.trackingtravel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maximvs.trackingtravel.databinding.FragmentRouteBinding


class RouteFragment : Fragment() {
    private lateinit var binding: FragmentRouteBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRouteBinding.inflate(inflater, container, false)

        return binding.root
    }
