package com.devexperto.damproject.ui.main

import androidx.lifecycle.*
import com.devexperto.damproject.model.Movie
import com.devexperto.damproject.model.repository.MoviesRepository
import kotlinx.coroutines.launch

class MainViewModel(moviesRepository: MoviesRepository) : ViewModel() {

    private val _state = MediatorLiveData<UIState>()
    val state: LiveData<UIState> get() = _state

    private val _localState = MutableLiveData(UIState())

    init {
        _state.addSource(_localState) { _state.value = it }
        _state.addSource(moviesRepository.movies) { _state.value = _state.value?.copy(movies = it) }

        viewModelScope.launch {
            _localState.value = _localState.value?.copy(loading = true)
            moviesRepository.requestMovies()
            _localState.value = _localState.value?.copy(loading = false)
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