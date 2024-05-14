package com.example.utsmobileprograming

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class Dashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val listView: ListView = findViewById(R.id.listView)

        val newsList = arrayListOf(
            AdobeItem("Adobe Photoshop", "Aplikasi untuk mengedit dan memanipulasi gambar", R.drawable.adobe1),
            AdobeItem("Adobe Illustrator", "Aplikasi untuk membuat vektor dan ilustrasi", R.drawable.adobe2),
            AdobeItem("Adobe Premiere Pro", "Aplikasi untuk mengedit video", R.drawable.adobe3),
            AdobeItem("Adobe Acrobat Reader", "Aplikasi untuk membuka dan membaca file PDF", R.drawable.adobe4)
        )

        val adapter = Adapter(this, R.layout.adobe_list, newsList)

        listView.adapter = adapter

        val btnLogout: Button = findViewById(R.id.btnLogout)

        btnLogout.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }
    }
}
