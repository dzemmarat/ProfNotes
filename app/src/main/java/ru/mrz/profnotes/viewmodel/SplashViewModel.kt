package ru.mrz.profnotes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.mrz.profnotes.data.model.LocalNote
import ru.mrz.profnotes.data.repository.AuthRepository
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val authRepository: AuthRepository,
) : ViewModel() {
    fun getIsFirstAuth(): Boolean = authRepository.getIsFirstAuth()

    fun setIsFirstAuth(value: Boolean) {
        authRepository.setIsFirstAuth(value)
    }

    fun addNote(note: LocalNote) {
        viewModelScope.launch {
            authRepository.addNote(note)
        }
    }
}