package ru.mrz.profnotes.data.network.api

import retrofit2.Response
import retrofit2.http.GET
import ru.mrz.profnotes.data.model.Note
import ru.mrz.profnotes.data.model.NoteResponse

interface NoteApi {
    @GET("notes")
    fun getNotes(): NoteResponse

    @GET("todo3")
    suspend fun getNote(): Response<Note>
}