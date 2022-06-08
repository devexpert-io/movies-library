package com.devexperto.damproject.model

import com.devexperto.damproject.model.Movie as DomainMovie
import com.devexperto.damproject.model.db.Movie as DbMovie
import com.devexperto.damproject.model.server.Movie as ServerMovie

fun ServerMovie.toDbMovie(): DbMovie = DbMovie(
    id,
    title,
    "https://image.tmdb.org/t/p/w185/$posterPath"
)

fun DbMovie.toDomainMovie(): DomainMovie = DomainMovie(id, title, posterPath)