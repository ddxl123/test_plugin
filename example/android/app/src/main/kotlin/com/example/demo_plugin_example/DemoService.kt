package com.example.demo_plugin_example

import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.view.WindowManager
import android.widget.Button
import androidx.annotation.RequiresApi

class DemoService : Service() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val windowManager = getSystemService(WINDOW_SERVICE) as WindowManager;
        val layoutParams = WindowManager.LayoutParams();
        layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
        layoutParams.width = 300
        layoutParams.height = 300

        val button = Button(this)
        button.text = "text"
        windowManager.addView(button, layoutParams)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}