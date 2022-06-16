package com.devexperto.damproject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel2 extends ViewModel {

    private MutableLiveData<LoginViewModel.UiState> state;

    public LiveData<LoginViewModel.UiState> getLiveData() {
        return state;
    }

    public LoginViewModel2() {
        state = new MutableLiveData(new LoginViewModel.UiState());
    }
}
