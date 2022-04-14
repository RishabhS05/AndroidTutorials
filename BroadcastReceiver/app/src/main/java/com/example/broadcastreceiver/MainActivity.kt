package com.example.broadcastreceiver

import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class MainActivity : AppCompatActivity() {
    private val dynamicBroadcastReceiver: DynamicBroadcastReceiver = DynamicBroadcastReceiver()
    private val ACTION = "com.example.broadcastreceiver.EXAMPLE_ACTION"
    private val localBroadcastReceiver= LocalBroadcastReceiver()
    val localBroadcastManager: LocalBroadcastManager by lazy {
        LocalBroadcastManager.getInstance(this@MainActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intentFilter = IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED)
        registerReceiver(dynamicBroadcastReceiver, intentFilter)
        localBroadcastManager.registerReceiver(localBroadcastReceiver, IntentFilter(ACTION))
        findViewById<Button>(R.id.localBroadcastBtn).setOnClickListener {
            localBroadcastManager.sendBroadcast(Intent(ACTION))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(dynamicBroadcastReceiver)
        localBroadcastManager.unregisterReceiver(localBroadcastReceiver)
    }

}