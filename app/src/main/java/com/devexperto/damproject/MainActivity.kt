package com.devexperto.damproject

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val button = findViewById<Button>(R.id.login)

        button.setOnClickListener {
            Toast.makeText(
                this,
                "Email: ${email.text}, Password: ${password.text}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}