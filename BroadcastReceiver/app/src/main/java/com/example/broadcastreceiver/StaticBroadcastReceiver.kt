package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
/**
 * Static BroadCast receiver
 *
 * Most of the Broadcast are deprecated in api level 24 or higher
 *
 * These type of Broadcasts are declared in the manifest file and works even if the app is closed.
 * These are also create another entry point for the app.
 * */
class StaticBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        StringBuilder().apply {
            append("Action: ${intent?.action}\n")
            append("URI: ${intent?.toUri(Intent.URI_INTENT_SCHEME)}\n")
            toString().also { log ->
                Log.d("MyBroadcastReceiver", log)
                Toast.makeText(context, log, Toast.LENGTH_LONG).show()
            }
        }
    }
}
