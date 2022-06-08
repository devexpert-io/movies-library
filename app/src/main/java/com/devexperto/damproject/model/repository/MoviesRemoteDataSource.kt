package com.devexperto.damproject.model.repository

import com.devexperto.damproject.model.Movie
import com.devexperto.damproject.model.server.RemoteConnection
import com.devexperto.damproject.model.toDomainMovie

class MoviesRemoteDataSource(private val apiKey: String) {
    suspend fun getPopularMovies(): List<Movie> {
        val results = RemoteConnection.service.listPopularMovies(apiKey).results
        return results.map { it.toDomainMovie() }
    }
}