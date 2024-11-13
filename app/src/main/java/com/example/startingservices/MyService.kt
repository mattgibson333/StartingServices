package com.example.startingservices

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    override fun onCreate() {
        super.onCreate()
        Log.d("MyService", "Service created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("MyService", "Service started")
        // Run your background task here (e.g., thread or coroutine)
        return START_STICKY  // Service is restarted if it gets terminated
    }

    override fun onBind(intent: Intent?): IBinder? {
        // Return null if not binding the service (use for bound services)
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyService", "Service destroyed")
    }
}
