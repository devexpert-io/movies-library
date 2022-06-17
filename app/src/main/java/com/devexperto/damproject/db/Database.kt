package com.devexperto.damproject.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    version = 1,
    entities = [LoginTime::class]
)
//@TypeConverters(DateTypeConverter::class)
abstract class Database : RoomDatabase() {

    abstract fun loginTimeDao(): LoginTimeDao

}