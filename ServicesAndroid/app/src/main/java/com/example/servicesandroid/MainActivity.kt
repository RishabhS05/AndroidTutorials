package com.example.servicesandroid

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.servicesandroid.service.MyForegroundService
import com.example.servicesandroid.service.MyService

import android.app.ActivityManager
import android.content.Context


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val playBtn = findViewById<Button>(R.id.playBtn)
        val stopBtn = findViewById<Button>(R.id.stopBtn)
        val playforeBtn = findViewById<Button>(R.id.playForegroundBtn)
        val stopforeBtn = findViewById<Button>(R.id.stopForegroundBtn)

        playBtn.setOnClickListener {
//            creating an Intent for the background service and starting the service by calling startService()
            startService(Intent(this, MyService::class.java))
        }
        stopBtn.setOnClickListener { stopService(Intent(this@MainActivity, MyService::class.java)) }
        playforeBtn.setOnClickListener {
//            creating an Intent for the foreground service and starting the service by calling startForegroundService()

            if(!foregroundServiceRunning()) {
                val intent = Intent(this@MainActivity, MyForegroundService::class.java)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(intent)
                } else {
                    startService(intent)
                }
            }
        }
        stopforeBtn.setOnClickListener { stopService(Intent(this@MainActivity, MyForegroundService::class.java)) }
    }
    private fun foregroundServiceRunning(): Boolean {
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        for (service in activityManager.getRunningServices(Int.MAX_VALUE)) {
            if (MyForegroundService::class.java.name == service.service.className) {
                return true
            }
        }
        return false
    }
}