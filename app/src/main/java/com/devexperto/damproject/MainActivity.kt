package com.devexperto.damproject

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.devexperto.damproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(ActivityMainBinding.inflate(layoutInflater)) {
            setContentView(root)

            login.setOnClickListener {
                Toast.makeText(
                    this@MainActivity,
                    "Email: ${email.text}, Password: ${password.text}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

}