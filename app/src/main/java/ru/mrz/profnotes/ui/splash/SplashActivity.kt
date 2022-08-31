package ru.mrz.profnotes.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import ru.mrz.profnotes.MainActivity
import ru.mrz.profnotes.viewmodel.SplashViewModel

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(
            this,
            viewModel.getIsFirstEnter().toString(),
            Toast.LENGTH_LONG
        ).show()
        viewModel.setIsFirstEnter(false)

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}