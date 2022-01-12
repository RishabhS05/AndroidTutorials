package com.example.servicesandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.servicesandroid.service.MyService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val playBtn  = findViewById<Button>(R.id.playBtn)
        val stopBtn  = findViewById<Button>(R.id.stopBtn)
        val pauseBtn  = findViewById<Button>(R.id.pauseBtn)
        playBtn.setOnClickListener {
//            creating an Intent for the background service and starting the service by calling startService()
            startService(Intent(this,MyService::class.java))
        }
        stopBtn.setOnClickListener {  stopService(Intent(this, MyService::class.java)) }
        pauseBtn.setOnClickListener {

        }
    }
}