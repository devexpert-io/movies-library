package com.devexperto.damproject.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devexperto.damproject.model.Movie
import com.devexperto.damproject.model.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    movieId: Int,
    private val moviesRepository: MoviesRepository
) : ViewModel() {

    val state: LiveData<Movie> = moviesRepository.findById(movieId)

    fun onSwitchFavoriteClick() {
        viewModelScope.launch {
            state.value?.let { moviesRepository.switchFavorite(it) }
        }
    }
}