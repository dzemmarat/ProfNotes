package ru.mrz.profnotes.data.model

data class MyNote(
    val id: Int,
    val title: String,
    val date: String,
    val status: String, // TODO need to change to enum!
    val description: String
)
