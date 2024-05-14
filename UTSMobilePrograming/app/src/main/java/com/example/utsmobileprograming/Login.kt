package com.example.utsmobileprograming

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btn: TextView = findViewById(R.id.textDaftar)
        btn.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }

        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)

        val loginBtn: TextView = findViewById(R.id.btnLogin1)
        loginBtn.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        if (email.isEmpty()) {
            Toast.makeText(applicationContext, "Email tidak boleh kosong", Toast.LENGTH_SHORT).show()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(applicationContext, "Masukkan email yang valid", Toast.LENGTH_SHORT).show()
            return
        }

        if (password.isEmpty()) {
            Toast.makeText(applicationContext, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
            return
        }

        startActivity(Intent(this, Dashboard::class.java))
    }
}