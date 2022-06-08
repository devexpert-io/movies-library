package com.devexperto.damproject.ui.detail

import androidx.lifecycle.*
import com.devexperto.damproject.model.Movie
import com.devexperto.damproject.model.db.MovieDao
import com.devexperto.damproject.model.toDomainMovie
import kotlinx.coroutines.launch

class DetailViewModel(movieId: Int, movieDao: MovieDao) : ViewModel() {

    private val _state = MutableLiveData<Movie>()
    val state: LiveData<Movie> get() = _state

    init {
        viewModelScope.launch {
            _state.value = movieDao.findById(movieId).toDomainMovie()
        }
    }
}

@Suppress("UNCHECKED_CAST")
class DetailViewModelFactory(private val movieId: Int, private val movieDao: MovieDao) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(movieId, movieDao) as T
    }
}