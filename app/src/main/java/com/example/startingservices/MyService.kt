package com.example.startingservices

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.*

class MyService : Service() {
    private var countdownJob = Job()
    private val serviceScope = CoroutineScope(Dispatchers.Default + countdownJob)

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("MyService", "Service started")
        val countdownValue = intent?.getIntExtra("countdown", 10) ?: 10

        serviceScope.launch {
            for (i in countdownValue downTo 1) {
                Log.d("MyService", "Countdown: $i")
                delay(1000)
            }
            Log.d("MyService", "Countdown finished")
        }

        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        countdownJob.cancel()
        Log.d("MyService", "Service destroyed")
    }
}
