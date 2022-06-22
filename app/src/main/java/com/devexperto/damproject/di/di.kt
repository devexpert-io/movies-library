package com.devexperto.damproject

import android.app.Application
import androidx.room.Room
import com.devexperto.damproject.di.ApiKey
import com.devexperto.damproject.model.db.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideDatabase(app: Application): MovieDatabase = Room.databaseBuilder(
        app,
        MovieDatabase::class.java, "movie-db"
    ).build()

    @Singleton
    @Provides
    fun provideMovieDao(db: MovieDatabase) = db.movieDao()

    @Singleton
    @Provides
    @ApiKey
    fun provideApiKey(app: Application): String = app.getString(R.string.api_key)

    @Singleton
    @Provides
    fun provideAppName(app: Application): String = app.getString(R.string.app_name)
}