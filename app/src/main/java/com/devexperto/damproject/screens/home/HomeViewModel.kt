package com.devexperto.damproject.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devexperto.damproject.db.LoginTimeDao

class HomeViewModel(loginTimeDao: LoginTimeDao) : ViewModel() {

    val state = loginTimeDao.getAll()
}

@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory(private val loginTimeDao: LoginTimeDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(loginTimeDao) as T
    }

}