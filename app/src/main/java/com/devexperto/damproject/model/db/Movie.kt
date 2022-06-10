package com.devexperto.damproject.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val posterPath: String,
    val favorite: Boolean
)