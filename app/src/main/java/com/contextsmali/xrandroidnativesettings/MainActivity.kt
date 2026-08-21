package com.contextsmali.xrandroidnativesettings

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast

class MainActivity : Activity() {
    private val settingsPackage = "com.android.settings"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(
            this,
            "Press Open on this window to open Settings.",
            Toast.LENGTH_LONG
        ).show()

        openSettings()
    }

    private fun openSettings() {
        try {
            val intent = Intent(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.parse("package:$settingsPackage")
            )

            intent.addFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK or
                Intent.FLAG_ACTIVITY_TASK_ON_HOME
            )

            startActivity(intent)
            finish()
        } catch (_: Exception) {
            try {
                val intent = packageManager.getLaunchIntentForPackage(settingsPackage)

                if (intent != null) {
                    intent.addFlags(
                        Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_TASK_ON_HOME
                    )

                    startActivity(intent)
                }
            } catch (_: Exception) {
            }

            finish()
        }
    }
}
