package com.devexperto.damproject.screens.login

import androidx.lifecycle.*
import com.devexperto.damproject.db.LoginTime
import com.devexperto.damproject.db.LoginTimeDao
import kotlinx.coroutines.launch

class LoginViewModel(private val loginTimeDao: LoginTimeDao) : ViewModel() {

    private val _state = MutableLiveData(UiState())
    val state: LiveData<UiState>
        get() = _state

    fun doLogin(email: String, pass: String) {
        if (isLoginValid(email, pass)) {
            _state.value = _state.value?.copy(showError = false, navigateToHome = true)
            saveLoginTime(email)
        } else {
            _state.value = _state.value?.copy(showError = true)
        }
    }

    private fun saveLoginTime(email: String) {
        viewModelScope.launch {
            loginTimeDao.save(LoginTime(0, email, System.currentTimeMillis()))
        }
    }

    private fun isLoginValid(email: String, pass: String): Boolean {
        val emailValid = email.isNotEmpty() && email.contains('@')
        val passValid = pass.isNotEmpty() && pass.length > 5

        return emailValid && passValid
    }

    fun onNavigationDone() {
        _state.value = _state.value?.copy(navigateToHome = false)
    }

    data class UiState(
        val showError: Boolean = false,
        val navigateToHome: Boolean = false
    )

}

@Suppress("UNCHECKED_CAST")
class LoginViewModelFactory(private val loginTimeDao: LoginTimeDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(loginTimeDao) as T
    }

}