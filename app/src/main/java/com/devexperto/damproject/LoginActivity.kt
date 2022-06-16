package com.devexperto.damproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private val vm: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val button = findViewById<Button>(R.id.login)
        val error = findViewById<TextView>(R.id.error)

        button.setOnClickListener {
            vm.doLogin(email.text.toString(), password.text.toString())
        }

        vm.state.observe(this) { state ->
            error.visibility = if (state.showError) View.VISIBLE else View.GONE
            if (state.navigateToHome) {
                startActivity(Intent(this, HomeActivity::class.java))
                vm.onNavigationDone()
            }
        }
    }
}