package com.devexperto.damproject.model.server

import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteService {

    @GET("discover/movie?sort_by=popularity.desc")
    suspend fun listPopularMovies(@Query("api_key") apiKey: String): RemoteResult

    @GET("discover/movie?sort_by=vote_average.desc")
    suspend fun listMostVotedMovies(@Query("api_key") apiKey: String): RemoteResult

}