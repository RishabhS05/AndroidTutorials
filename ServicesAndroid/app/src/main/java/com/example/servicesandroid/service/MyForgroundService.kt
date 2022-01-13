package com.example.servicesandroid.service

import android.app.Notification
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.provider.Settings
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.example.servicesandroid.R
import android.app.NotificationManager

import android.app.NotificationChannel

/**
 * Foreground Service : This is a service that stays alive even when the app is terminated and run the task until it finish that task or stop by the user.
* */
class MyForegroundService : Service() {
    /**
     * Steps to create Foreground Service
     * 1) Create a class and extend it with Service Class or Extend (indirect or direct)Subclasses of service class (ex : InputMethodService , RecognitionService, SpellCheckService, RemoteViewService)
     * 2) Override onBind and onStartCommand methods.
     * 3) Add it into the manifest file.
     * 4) Add Permission in the manifest file.
     * 5) create an intent in the activity to start the service.
     * 6) Start service by calling startService()
     * */
    private lateinit var media: MediaPlayer
    val NOTIFICATION_CHANNEL = "Music Player"
    override fun onBind(p0: Intent?): IBinder? {
        // A client is binding to the service with bindService()
        return null
    }

    override fun onDestroy() {
        stopForeground(true)
        super.onDestroy()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread(Runnable {
//            media = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
//            media.start()
            while (true) {
                Log.d("Foreground Service ", "Running .......")
                try {
                    Thread.sleep(1000)
                } catch ( e: InterruptedException) {
                    e.printStackTrace();
                }
            }

        }).start()

//        creating notification tray for show process on
        val channel = NotificationChannel(
            NOTIFICATION_CHANNEL,
            NOTIFICATION_CHANNEL,
            NotificationManager.IMPORTANCE_LOW
        )
        getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
        val notification = Notification.Builder(this, NOTIFICATION_CHANNEL)
            .setContentTitle("Music is playing")
            .setContentText("Your Favourite music is playing..")
            .setSmallIcon(R.mipmap.ic_launcher_round)

            .setCategory(NotificationCompat.CATEGORY_CALL)
            .setChannelId(NOTIFICATION_CHANNEL)
//            .setFullScreenIntent(fullScreenPendingIntent, true)
            .setAutoCancel(true)
            .build()
        startForeground(1001, notification)
        return super.onStartCommand(intent, flags, startId)
    }
}