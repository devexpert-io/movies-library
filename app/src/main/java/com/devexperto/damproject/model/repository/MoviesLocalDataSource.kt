package com.devexperto.damproject.model.repository

import com.devexperto.damproject.model.Movie
import com.devexperto.damproject.model.db.MovieDao
import com.devexperto.damproject.model.toDbMovie
import com.devexperto.damproject.model.toDomainMovie

class MoviesLocalDataSource(private val movieDao: MovieDao) {
    suspend fun isEmpty(): Boolean = movieDao.movieCount() == 0

    suspend fun save(movies: List<Movie>) {
        movieDao.insertMovies(movies.map { it.toDbMovie() })
    }

    suspend fun getAll(): List<Movie> = movieDao.getAll().map { it.toDomainMovie() }

    suspend fun findById(movieId: Int): Movie = movieDao.findById(movieId).toDomainMovie()
}