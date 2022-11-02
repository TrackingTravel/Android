package com.maximvs.trackingtravel

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import com.maximvs.trackingtravel.databinding.FragmentRequestBinding


class RequestFragment : Fragment() {
    private lateinit var binding: FragmentRequestBinding

    private val requestGeoPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission(),
        ::onGotGeoPermissionResult
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRequestBinding.inflate(inflater, container, false)

        binding.requestGeoPermissionButton.setOnClickListener {
            requestGeoPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }

        binding.startButton.setOnClickListener {
            (activity as MainActivity).startRouteFragment()
        }

        return binding.root
    }

    private fun onGotGeoPermissionResult(granted: Boolean) {
        if (granted) {
            onGeoPermissionGranted()
        } else {
            if (!shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {
                askUserForOpeningAppSettings()
            } else {
                Toast.makeText(activity, "В разрешении отказано", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun askUserForOpeningAppSettings() {
        val appSettingsIntent = Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
            Uri.fromParts("package", activity?.getPackageName(), null)
        )
        if (activity?.getPackageManager()?.resolveActivity(appSettingsIntent, PackageManager.MATCH_DEFAULT_ONLY) == null) {
            Toast.makeText(activity, "В разрешении отказано навсегда", Toast.LENGTH_SHORT).show()
        } else {
            AlertDialog.Builder(requireContext())
                .setTitle("В разрешении отказано")
                .setMessage("В разрешении отказано навсегда." +
                        "Вы можете изменить это в настройках телефона.\n\n" +
                        "Хотите перейти в настройки?")
                .setPositiveButton("Перейти") { _, _ ->
                    startActivity(appSettingsIntent)
                }
                .create()
                .show()
        }
    }

    private fun onGeoPermissionGranted() {
        Toast.makeText(activity, "Геолокация включена", Toast.LENGTH_SHORT).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}