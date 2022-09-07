package ru.mrz.profnotes.viewmodel.core

sealed class Event {
    object Idle: Event()

    data class Toast(
        val message: String
    ): Event()
}
