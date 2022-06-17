package com.devexperto.damproject.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LoginTimeDao {

    @Query("SELECT * FROM LoginTime")
    suspend fun getAll(): List<LoginTime>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun save(loginTime: LoginTime)
}