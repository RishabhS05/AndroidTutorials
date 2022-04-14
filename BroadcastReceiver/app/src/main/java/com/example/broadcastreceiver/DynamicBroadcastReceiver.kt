package com.example.broadcastreceiver

import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * Dynamic Broadcast Receivers are created programmatically and it is triggered if the app is active or in background.
 * Since From Api level 26 most of the broadcast receiver caught by the dynamic receiver. */
class DynamicBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
//        Toast.makeText(context, "DynamicBroadCast Receiver", Toast.LENGTH_SHORT).show()

        val action = intent?.action

        if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
            val state = intent?.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR)
            var status = ""
            when (state) {
                BluetoothAdapter.STATE_OFF -> {
                    status = "OFF"
                }

                BluetoothAdapter.STATE_TURNING_OFF -> {
                    status = "Turning OFF"
                }

                BluetoothAdapter.STATE_ON -> {
                    status = "ON"
                }

                BluetoothAdapter.STATE_TURNING_ON -> {
                    status = "Turning ON"
                }
            }
            Toast.makeText(context, "Dynamic BR Bluetooth is $status", Toast.LENGTH_SHORT).show()
        }
    }
}
