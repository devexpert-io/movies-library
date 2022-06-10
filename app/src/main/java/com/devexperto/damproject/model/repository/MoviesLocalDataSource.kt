package com.devexperto.damproject.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.devexperto.damproject.model.Movie
import com.devexperto.damproject.model.db.MovieDao
import com.devexperto.damproject.model.toDbMovie
import com.devexperto.damproject.model.toDomainMovie

class MoviesLocalDataSource(private val movieDao: MovieDao) {
    suspend fun isEmpty(): Boolean = movieDao.movieCount() == 0

    suspend fun save(movies: List<Movie>) {
        movieDao.insertMovies(movies.map { it.toDbMovie() })
    }

    fun getAll(): LiveData<List<Movie>> =
        movieDao.getAll().map { movies -> movies.map { it.toDomainMovie() } }

    fun findById(movieId: Int): LiveData<Movie> =
        movieDao.findById(movieId).map { it.toDomainMovie() }
}