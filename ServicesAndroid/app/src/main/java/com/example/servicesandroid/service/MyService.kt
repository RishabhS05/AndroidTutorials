package com.example.servicesandroid.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class MyService : Service() {
    /**
     * A service is an application component that can perform long-running operation in the background with on user interface
     * Types of services
     *
     *
     * */
    private lateinit var media: MediaPlayer
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//     this method called everytime when you start service by startService() or startForegroundService().
        media = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        media.start()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::media.isInitialized) media.stop()
        stopSelf()
    }
}
