package com.devexperto.damproject.model.repository

import androidx.lifecycle.LiveData
import com.devexperto.damproject.model.Movie
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    private val moviesLocalDataSource: MoviesLocalDataSource,
    private val moviesRemoteDataSource: MoviesRemoteDataSource
) {
    val movies: LiveData<List<Movie>> = moviesLocalDataSource.getAll()

    suspend fun requestMovies() {
        if (moviesLocalDataSource.isEmpty()) {
            val movies = moviesRemoteDataSource.getPopularMovies()
            moviesLocalDataSource.save(movies)
        }
    }

    fun findById(movieId: Int): LiveData<Movie> = moviesLocalDataSource.findById(movieId)

    suspend fun switchFavorite(movie: Movie) {
        val updated = movie.copy(favorite = !movie.favorite)
        moviesLocalDataSource.save(listOf(updated))
    }
}