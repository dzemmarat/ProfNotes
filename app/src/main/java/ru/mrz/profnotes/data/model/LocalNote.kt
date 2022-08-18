package ru.mrz.profnotes.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "localNote")
data class LocalNote(
    val title: String,
    val date: String,
    val status: String, // TODO need to change to enum!
    val description: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
