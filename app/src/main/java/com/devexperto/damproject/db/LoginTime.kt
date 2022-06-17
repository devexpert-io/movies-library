package com.devexperto.damproject.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.util.*

@Entity
data class LoginTime(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val user: String,
    val date: Long
)

/*class DateTypeConverter {

    @TypeConverter
    fun fromDate(date: Date): Long = date.time

    @TypeConverter
    fun toDate(date: Long): Date = Date(date)
}*/