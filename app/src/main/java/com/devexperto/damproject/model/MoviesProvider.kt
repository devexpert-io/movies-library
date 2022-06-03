package com.devexperto.damproject.model

object MoviesProvider {

    fun getMovies(): List<Movie> {
        Thread.sleep(2000)
        return (1..100).map { Movie("Title $it", "https://loremflickr.com/240/320/dog?lock=$it") }
    }
}