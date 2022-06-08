package com.devexperto.damproject.ui.main

import androidx.lifecycle.*
import com.devexperto.damproject.model.Movie
import com.devexperto.damproject.model.db.MovieDao
import com.devexperto.damproject.model.repository.MoviesRepository
import kotlinx.coroutines.launch

class MainViewModel(moviesRepository: MoviesRepository) : ViewModel() {

    private val _state = MutableLiveData(UIState())
    val state: LiveData<UIState> get() = _state

    init {
        viewModelScope.launch {
            _state.value = _state.value?.copy(loading = true)
            _state.value = _state.value?.copy(loading = false, movies = moviesRepository.getAll())
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

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val moviesRepository: MoviesRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(moviesRepository) as T
    }

}