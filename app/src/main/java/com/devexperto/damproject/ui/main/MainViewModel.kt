package com.devexperto.damproject.ui.main

import androidx.lifecycle.*
import com.devexperto.damproject.model.Movie
import com.devexperto.damproject.model.db.MovieDao
import com.devexperto.damproject.model.server.RemoteConnection
import com.devexperto.damproject.model.toDbMovie
import com.devexperto.damproject.model.toDomainMovie
import kotlinx.coroutines.launch

class MainViewModel(private val apiKey: String, private val movieDao: MovieDao) : ViewModel() {

    private val _state = MutableLiveData(UIState())
    val state: LiveData<UIState> get() = _state

    init {
        viewModelScope.launch {
            _state.value = _state.value?.copy(loading = true)
            _state.value = _state.value?.copy(loading = false, movies = requestMovies())
        }
    }

    private suspend fun requestMovies(): List<Movie> {
        if (movieDao.movieCount() == 0) {
            val serverResult = RemoteConnection.service.listPopularMovies(apiKey).results
            movieDao.insertMovies(serverResult.map { it.toDbMovie() })
        }

        return movieDao.getAll().map { it.toDomainMovie() }
    }

    fun onMovieClicked(movie: Movie) {
        _state.value = _state.value?.copy(navigateTo = movie)
    }

    fun onNavigationDone() {
        _state.value = _state.value?.copy(navigateTo = null)
    }

    data class UIState(
        val loading: Boolean = false,
        val movies: List<Movie>? = null,
        val navigateTo: Movie? = null
    )
}

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val apiKey: String, private val movieDao: MovieDao) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(apiKey, movieDao) as T
    }

}