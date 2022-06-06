package com.devexperto.damproject.ui.main

import androidx.lifecycle.*
import com.devexperto.damproject.model.Movie
import com.devexperto.damproject.model.MoviesProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    private val _state = MutableLiveData(UIState())
    val state: LiveData<UIState> get() = _state

    init {
        viewModelScope.launch {
            _state.value = _state.value?.copy(loading = true)
            val result = withContext(Dispatchers.IO) { MoviesProvider.getMovies() }
            _state.value = _state.value?.copy(loading = false, movies = result)
        }
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