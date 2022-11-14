package com.maximvs.trackingtravel.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.maximvs.trackingtravel.R
import com.maximvs.trackingtravel.view.Track
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {
    private lateinit var track: Track

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTracksDetails()

    }

    private fun setTracksDetails() {
        track = arguments?.get("track") as Track

        //Устанавливаем заголовок
        details_toolbar.title = track.title
        //Устанавливаем картинку
        details_photo.setImageResource(track.photo)
        //Устанавливаем описание
        details_description.text = track.description


    }
}
