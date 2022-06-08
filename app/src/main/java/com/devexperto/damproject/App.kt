package com.devexperto.damproject

import android.app.Application
import androidx.room.Room
import com.devexperto.damproject.model.db.MovieDatabase

class App : Application() {

    lateinit var db: MovieDatabase
        private set

    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(
            this,
            MovieDatabase::class.java, "movie-db"
        ).build()
    }
}