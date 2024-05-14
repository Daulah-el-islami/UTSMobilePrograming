package com.example.utsmobileprograming

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.utsmobileprograming.R.*

class MainActivity : AppCompatActivity() {

    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private lateinit var img: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        img = findViewById(id.img)
        img.animate().alpha(1.0f).setDuration(4000L)

        handler = Handler(Looper.getMainLooper())
        runnable = Runnable {
            val dsp = Intent(this, Login::class.java)
            startActivity(dsp)
            finish()
        }
        handler.postDelayed(runnable, 4000L)
    }
}
