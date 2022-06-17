package com.devexperto.damproject

import android.app.Application
import androidx.room.Room
import com.devexperto.damproject.db.Database

class App : Application() {

    lateinit var db: Database

    override fun onCreate() {
        super.onCreate()
        db = Room
            .databaseBuilder(this, Database::class.java, "login-db")
            .build()
    }
}