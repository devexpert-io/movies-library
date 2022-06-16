package com.devexperto.damproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _state = MutableLiveData(UiState())
    val state: LiveData<UiState>
        get() = _state

    fun doLogin(email: String, pass: String) {
        if (isLoginValid(email, pass)) {
            _state.value = _state.value?.copy(showError = false, navigateToHome = true)
        } else {
            _state.value = _state.value?.copy(showError = true)
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