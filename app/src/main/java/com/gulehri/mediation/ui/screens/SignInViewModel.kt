package com.gulehri.mediation.ui.screens

import androidx.lifecycle.ViewModel
import com.gulehri.mediation.ui.states.SignInState
import com.gulehri.mediation.utils.Extension.debug
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/*
 * Created by Shahid Iqbal on 3/31/2024.
 */

class SignInViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SignInState())
    val uiState get() = _uiState.asStateFlow()

    fun updateEmail(email: String) {
        _uiState.update {
            it.copy(email = email)
        }
    }

    fun updatePassword(password: String) {
        _uiState.update {
            it.copy(password = password)
        }
    }

}