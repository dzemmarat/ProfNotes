package ru.mrz.profnotes.data.local.utils

import android.content.Context
import androidx.core.content.edit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Prefs @Inject constructor(
    private val context: Context,
) {
    private val authPrefs by lazy {
        context.getSharedPreferences(
            AUTH_PREFS_NAME,
            Context.MODE_PRIVATE
        )
    }

    var isFirstLaunch: Boolean
        get() = authPrefs.getBoolean(IS_FIRST_LAUNCH, true)
        set(value) {
            authPrefs.edit { putBoolean(IS_FIRST_LAUNCH, value) }
        }

    companion object {
        private const val AUTH_PREFS_NAME = "auth_prefs"
        private const val IS_FIRST_LAUNCH = "is_first_launch"
    }
}