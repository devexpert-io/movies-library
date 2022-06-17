package com.devexperto.damproject.ui.main

import androidx.lifecycle.*
import com.devexperto.damproject.model.Movie
import com.devexperto.damproject.model.server.RemoteConnection
import com.devexperto.damproject.model.server.toDomainMovie
import kotlinx.coroutines.launch

class MainViewModel(apiKey: String) : ViewModel() {

    private val _state = MutableLiveData(UIState())
    val state: LiveData<UIState> get() = _state

    init {
        /*viewModelScope.launch {
            _state.value = _state.value?.copy(loading = true)
            val movies = RemoteConnection.service.listPopularMovies(apiKey).results
            _state.value = _state.value?.copy(
                loading = false,
                movies = movies.map { it.toDomainMovie() })
        }*/
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
class MainViewModelFactory(private val apiKey: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(apiKey) as T
    }

}