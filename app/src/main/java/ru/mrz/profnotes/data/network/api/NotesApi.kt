package ru.mrz.profnotes.data.network.api

import retrofit2.http.GET
import ru.mrz.profnotes.data.model.Note
import ru.mrz.profnotes.data.model.NoteResponse

interface NotesApi {
    @GET("notes")
    fun getNotes(): NoteResponse

    @GET("todos/1")
    suspend fun getNote() : Note
}