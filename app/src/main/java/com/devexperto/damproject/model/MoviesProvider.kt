package com.devexperto.damproject.model

object MoviesProvider {

    fun getMovies(type: String = "cats"): List<Movie> {
        Thread.sleep(2000)
        return (1..100).map { Movie("Title $it", "https://loremflickr.com/240/320/$type?lock=$it") }
    }
}