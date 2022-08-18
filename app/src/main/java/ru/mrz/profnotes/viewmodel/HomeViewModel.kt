package ru.mrz.profnotes.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.mrz.profnotes.data.model.LocalNote
import ru.mrz.profnotes.data.repository.AuthRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val authRepository: AuthRepository,
) : ViewModel() {
    fun getNotes(): Flow<List<LocalNote>> = flow {
        emit(authRepository.getNotes())
    }
}