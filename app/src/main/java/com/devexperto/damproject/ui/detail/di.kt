package com.devexperto.damproject.ui.detail

import androidx.lifecycle.SavedStateHandle
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DetailViewModelModule {

    @Provides
    fun provideMovieId(savedStateHandle: SavedStateHandle): Int {
        val args = DetailFragmentArgs.fromSavedStateHandle(savedStateHandle)
        return args.movieId
    }

}