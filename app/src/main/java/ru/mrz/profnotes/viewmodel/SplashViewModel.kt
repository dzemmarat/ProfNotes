package ru.mrz.profnotes.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.mrz.profnotes.data.repository.AuthRepository
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val authRepository: AuthRepository,
) : ViewModel() {
    fun getIsFirstEnter() = authRepository.getIsFirstEnter()

    fun setIsFirstEnter(value: Boolean) {
        authRepository.setIsFirstEnter(value)
    }
}