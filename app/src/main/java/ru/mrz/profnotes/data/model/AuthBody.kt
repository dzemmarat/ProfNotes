package ru.mrz.profnotes.data.model

data class AuthBody(
    val email: String,
    val login: String,
    val name: String,
    val password: String,
)