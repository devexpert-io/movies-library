package com.devexperto.damproject

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.devexperto.damproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            Toast.makeText(
                this,
                "Email: ${binding.email.text}, Password: ${binding.password.text}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}