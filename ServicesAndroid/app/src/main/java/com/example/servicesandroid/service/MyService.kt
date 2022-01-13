package com.example.servicesandroid.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
/**
 * A service is an application component that can perform long-running operation in the background with on user interface
 * Services names are according to there termination process not according to how they starts.
 * Types of services
 * 1) Background service : This service runs only when the app is running. it is terminated when the app is terminated.
 * 2) Foreground Service : This is a service that stays alive even when the app is terminated and run the task until it finish that task or stop by the user.
 * 3) Bound Service : This is a service that runs only when the component it is bound is running.
 * */


class MyService : Service() {
//    Background Service

    /**
     * Steps to create Background Service
     * 1) Create a class and extend it with Service Class or Extend (indirect or direct)Subclasses of service class (ex : InputMethodService , RecognitionService, SpellCheckService, RemoteViewService)
     * 2) Override onBind and onStartCommand methods.
     * 3) Add it into the manifest file.
     * 4) create an intent in the activity to start the service.
     * 5) Start service by calling startService()
     * */
    private lateinit var media: MediaPlayer
    override fun onBind(p0: Intent?): IBinder? {
        // A client is binding to the service with bindService()
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
