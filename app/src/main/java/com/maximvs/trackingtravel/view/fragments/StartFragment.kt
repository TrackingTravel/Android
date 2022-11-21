package com.maximvs.trackingtravel.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maximvs.trackingtravel.databinding.FragmentStartBinding
import com.maximvs.trackingtravel.view.MainActivity

class StartFragment : Fragment () {

    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentStartBinding.inflate(inflater, container, false)

        binding.btnBtn.setOnClickListener {
            (activity as MainActivity).startDetailsFragment()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}


