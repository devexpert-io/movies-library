package com.devexperto.damproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devexperto.damproject.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)
    }

}