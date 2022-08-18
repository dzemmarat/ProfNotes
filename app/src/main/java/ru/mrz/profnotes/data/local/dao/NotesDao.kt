package ru.mrz.profnotes.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.mrz.profnotes.data.model.LocalNote

@Dao
interface NotesDao {
    @Insert
    suspend fun addNote(note: LocalNote)

    @Query("SELECT * FROM localNote")
    suspend fun getNotes(): List<LocalNote>
}