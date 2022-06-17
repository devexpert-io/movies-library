package com.devexperto.damproject.screens.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.devexperto.damproject.App
import com.devexperto.damproject.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val recyclerView = findViewById<RecyclerView>(R.id.loginTimeList)
        val adapter = LoginTimeListAdapter()
        recyclerView.adapter = adapter

        val loginTime = (application as App).db.loginTimeDao().getAll()
        loginTime.observe(this) { adapter.submitList(it) }
    }
}