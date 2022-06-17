package com.devexperto.damproject.screens.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.devexperto.damproject.App
import com.devexperto.damproject.R

class HomeActivity : AppCompatActivity() {

    private val vm by viewModels<HomeViewModel> {
        HomeViewModelFactory((application as App).db.loginTimeDao())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val recyclerView = findViewById<RecyclerView>(R.id.loginTimeList)
        val adapter = LoginTimeListAdapter()
        recyclerView.adapter = adapter

        vm.state.observe(this) { adapter.submitList(it) }
    }
}