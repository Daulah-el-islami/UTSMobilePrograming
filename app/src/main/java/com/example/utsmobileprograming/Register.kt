package com.example.utsmobileprograming

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Register : AppCompatActivity() {

    companion object {
        private const val TAG = "Register"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btn: TextView = findViewById(R.id.textMasuk)
        btn.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }

        val registerButton: Button = findViewById(R.id.btnRegister)
        registerButton.setOnClickListener {
            val emailEditText: EditText = findViewById(R.id.et_email)
            val passwordEditText: EditText = findViewById(R.id.et_pass)

            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (!isEmailValid(email)) {
                emailEditText.error = "Email tidak valid"
                emailEditText.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty() || password.length < 8) {
                passwordEditText.error = "Password minimal 8 karakter"
                passwordEditText.requestFocus()
                return@setOnClickListener
            }

            Log.d(TAG, "Berhasil Mendaftar")

            Toast.makeText(this, "Berhasil Mendaftar", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
