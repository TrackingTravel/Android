package com.maximvs.trackingtravel

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.maximvs.trackingtravel.databinding.ActivityRequestBinding

class ActivityRequest : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)

    private val requestGeoPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission(),
        ::onGotGeoPermissionResult
    )

    @RequiresApi(Build.VERSION_CODES.M)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityRequestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.requestGeoPermissionButton.setOnClickListener {
            requestGeoPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)

    private fun onGotGeoPermissionResult(granted: Boolean) {
        if (granted) {
            onGeoPermissionGranted()
        } else {
            if (!shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                askUserForOpeningAppSettings()
            } else {
                Toast.makeText(this, "В разрешении отказано", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun askUserForOpeningAppSettings() {
        val appSettingsIntent = Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
            Uri.fromParts("package", packageName, null)
        )
        if (packageManager.resolveActivity(appSettingsIntent, PackageManager.MATCH_DEFAULT_ONLY) == null) {
            Toast.makeText(this, "В разрешении отказано навсегда", Toast.LENGTH_SHORT).show()
        } else {
            AlertDialog.Builder(this)
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
        Toast.makeText(this, "Геолокация включена", Toast.LENGTH_SHORT).show()
    }
}