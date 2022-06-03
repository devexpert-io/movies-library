package com.devexperto.damproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

    @Parcelize
    data class Movie(
        val title: String,
        val url: String
    ): Parcelable
