package ru.mrz.profnotes.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import ru.mrz.profnotes.data.model.LocalNote
import ru.mrz.profnotes.ui.activity.MainActivity
import ru.mrz.profnotes.viewmodel.SplashViewModel

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private val viewModel: SplashViewModel by viewModels()
    private val firstSetupNotes: List<LocalNote> = listOf(
        LocalNote(
            title = "One",
            date = "Today",
            status = "New",
            description = "Test"
        ),
        LocalNote(
            title = "Two",
            date = "Today",
            status = "New",
            description = "Test"
        ),
        LocalNote(
            title = "Three",
            date = "Today",
            status = "New",
            description = "Test"
        ),
        LocalNote(
            title = "Test",
            date = "Today",
            status = "New",
            description = "Test"
        ),
        LocalNote(
            title = "12",
            date = "Today",
            status = "New",
            description = "Test"
        ),
        LocalNote(
            title = "123",
            date = "Today",
            status = "New",
            description = "Test"
        ),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (viewModel.getIsFirstAuth()) {
            firstSetupNotes.forEach {
                viewModel.addNote(it)
            }
            viewModel.setIsFirstAuth(false)
        }
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}