package ru.mrz.profnotes.data.repository

import ru.mrz.profnotes.data.model.Note
import ru.mrz.profnotes.data.model.util.ResponseWrapper
import ru.mrz.profnotes.data.network.api.NoteApi
import ru.mrz.profnotes.data.repository.core.BaseRepository
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteApi: NoteApi,
) : BaseRepository() {
    suspend fun getNote(): ResponseWrapper<Note> =
        getResponseInResponseWrapper(noteApi.getNote())
}