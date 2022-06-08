package com.devexperto.damproject.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(val id: Int, val title: String, val url: String) : Parcelable
