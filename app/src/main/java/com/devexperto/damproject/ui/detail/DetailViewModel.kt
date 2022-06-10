package com.devexperto.damproject.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.devexperto.damproject.model.Movie
import com.devexperto.damproject.model.repository.MoviesRepository
import kotlinx.coroutines.launch

class DetailViewModel(movieId: Int, private val moviesRepository: MoviesRepository) : ViewModel() {

    val state: LiveData<Movie> = moviesRepository.findById(movieId)

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