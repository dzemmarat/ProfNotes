package ru.mrz.profnotes.data.repository

import ru.mrz.profnotes.data.local.dao.NotesDao
import ru.mrz.profnotes.data.local.utils.Prefs
import ru.mrz.profnotes.data.model.LocalNote
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val prefs: Prefs,
    private val notesDao: NotesDao,
) {
    fun getIsFirstAuth() = prefs.isFirstLaunch

    fun setIsFirstAuth(value: Boolean) {
        prefs.isFirstLaunch = value
    }

    suspend fun addNote(note: LocalNote) {
        notesDao.addNote(note)
    }

    suspend fun getNotes(): List<LocalNote> = notesDao.getNotes()
}