package ru.mrz.profnotes.core.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.mrz.profnotes.data.local.dao.NotesDao
import ru.mrz.profnotes.data.local.db.NotesDb
import ru.mrz.profnotes.data.local.utils.Prefs
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideProfNotesDatabase(application: Application): NotesDb =
        Room.databaseBuilder(application, NotesDb::class.java, NotesDb.DATABASE_NAME)
            .build()

    @Provides
    @Singleton
    fun provideOrdersDao(db: NotesDb): NotesDao = db.notesDao()

    @Provides
    @Singleton
    fun providePref(
        @ApplicationContext context: Context
    ): Prefs = Prefs(context)
}