package com.eshakhov.screentestxml

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager

class MainActivity : AppCompatActivity() {
    private val bgColors = arrayOf(
        Color.WHITE,
        Color.BLACK,
        Color.RED,
        Color.GREEN,
        Color.BLUE,
        Color.CYAN,
        Color.DKGRAY,
        Color.GRAY,
        Color.LTGRAY,
        Color.MAGENTA,
        Color.YELLOW
    )
    var indexOfColors = 0
    private val sizeOfColors = bgColors.size
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val controller = window.insetsController
            if (controller != null) {
                controller.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                controller.systemBarsBehavior =
                    WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }

    fun changeBgColor(view: View) {
        if (indexOfColors == sizeOfColors) {
            indexOfColors = 0
        }
        view.setBackgroundColor(bgColors[indexOfColors])
        indexOfColors++
    }

}