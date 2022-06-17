package com.devexperto.damproject.model.server

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteService {

    @GET("discover/movie?sort_by=popularity.desc")
    fun listPopularMovies(@Query("api_key") apiKey: String): Call<RemoteResult>

    @GET("discover/movie?sort_by=vote_average.desc")
    fun listMostVotedMovies(@Query("api_key") apiKey: String): Call<RemoteResult>

}