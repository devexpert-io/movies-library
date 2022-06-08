package com.devexperto.damproject.model.repository

import com.devexperto.damproject.model.Movie

class MoviesRepository(
    private val moviesLocalDataSource: MoviesLocalDataSource,
    private val moviesRemoteDataSource: MoviesRemoteDataSource
) {

    suspend fun getAll(): List<Movie> {
        if (moviesLocalDataSource.isEmpty()) {
            val movies = moviesRemoteDataSource.getPopularMovies()
            moviesLocalDataSource.save(movies)
        }
        return moviesLocalDataSource.getAll()
    }

    suspend fun findById(movieId: Int): Movie = moviesLocalDataSource.findById(movieId)
}