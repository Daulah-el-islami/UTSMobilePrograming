package com.example.utsmobileprograming

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private lateinit var img: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img = findViewById(R.id.img)
        img.animate().alpha(4000f).duration = 0

        handler = Handler()
        runnable = Runnable {
            val dsp = Intent(this, Login::class.java)
            startActivity(dsp)
            finish()
        }
        handler.postDelayed(runnable, 4000)
    }
}