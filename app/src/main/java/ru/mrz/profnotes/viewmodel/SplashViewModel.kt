package ru.mrz.profnotes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.mrz.profnotes.data.model.Note
import ru.mrz.profnotes.data.model.util.ResponseWrapper
import ru.mrz.profnotes.data.repository.AuthRepository
import ru.mrz.profnotes.data.repository.NoteRepository
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