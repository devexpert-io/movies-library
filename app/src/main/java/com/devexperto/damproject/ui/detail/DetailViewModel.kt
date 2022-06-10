package com.devexperto.damproject.ui.detail

import androidx.lifecycle.*
import com.devexperto.damproject.model.Movie
import com.devexperto.damproject.model.repository.MoviesRepository
import kotlinx.coroutines.launch

class DetailViewModel(movieId: Int, private val moviesRepository: MoviesRepository) : ViewModel() {

    private val _state = MutableLiveData<Movie>()
    val state: LiveData<Movie> get() = _state

    init {
        viewModelScope.launch {
            _state.value = moviesRepository.findById(movieId)
        }
    }

    fun onSwitchFavoriteClick() {
        viewModelScope.launch {
            state.value?.let { moviesRepository.switchFavorite(it) }
        }
    }
}

@Suppress("UNCHECKED_CAST")
class DetailViewModelFactory(
    private val movieId: Int,
    private val moviesRepository: MoviesRepository
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(movieId, moviesRepository) as T
    }
}