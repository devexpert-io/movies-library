package com.devexperto.damproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    companion object {
        const val BUNDLE_KEY = "bundleKey"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val value = savedInstanceState?.getString(BUNDLE_KEY)

        if (value != null){
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(BUNDLE_KEY, "I've been saved!!")
        super.onSaveInstanceState(outState)
    }
}