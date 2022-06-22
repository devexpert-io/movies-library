package com.devexperto.damproject.model.repository

import com.devexperto.damproject.di.ApiKey
import com.devexperto.damproject.model.Movie
import com.devexperto.damproject.model.server.RemoteConnection
import com.devexperto.damproject.model.toDomainMovie
import javax.inject.Inject

class MoviesRemoteDataSource @Inject constructor(@ApiKey private val apiKey: String) {
    suspend fun getPopularMovies(): List<Movie> {
        val results = RemoteConnection.service.listPopularMovies(apiKey).results
        return results.map { it.toDomainMovie() }
    }
}