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

        showLongToast(
            "Press Open on this window to open Settings."
        )

        goToSettings()
    }

    private fun goToSettings() {
        try {
            val intent = packageManager.getLaunchIntentForPackage(settingsPackage)

            if (intent != null) {
                intent.addFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.FLAG_ACTIVITY_TASK_ON_HOME
                )

                startActivity(intent)
                finish()
                return
            }
        } catch (_: Exception) {
        }

        try {
            val intent = Intent(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.parse("package:$settingsPackage")
            )

            intent.setPackage(settingsPackage)

            intent.addFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK or
                Intent.FLAG_ACTIVITY_TASK_ON_HOME
            )

            startActivity(intent)

        } catch (_: Exception) {
        }

        finish()
    }

    private fun showLongToast(message: String) {
        val toast = Toast.makeText(
            applicationContext,
            message,
            Toast.LENGTH_LONG
        )

        toast.show()

        window.decorView.postDelayed(
            object : Runnable {
                private var elapsed = 0L
                private val duration = 10000L

                override fun run() {
                    if (elapsed < duration) {
                        toast.show()
                        elapsed += 2000L
                        window.decorView.postDelayed(this, 2000L)
                    }
                }
            },
            2000L
        )
    }
}
