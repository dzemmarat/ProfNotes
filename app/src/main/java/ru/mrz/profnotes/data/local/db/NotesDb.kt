package ru.mrz.profnotes.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.mrz.profnotes.data.local.dao.NotesDao
import ru.mrz.profnotes.data.local.db.NotesDb.Companion.DATABASE_VERSION
import ru.mrz.profnotes.data.model.LocalNote

@Database(
    entities = [
        LocalNote::class
    ],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class NotesDb : RoomDatabase() {
    abstract fun notesDao(): NotesDao

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "NotesDb"
    }
}