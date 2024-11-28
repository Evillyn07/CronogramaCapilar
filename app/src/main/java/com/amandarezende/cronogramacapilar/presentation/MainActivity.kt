package com.amandarezende.cronogramacapilar.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.amandarezende.cronogramacapilar.R
import com.amandarezende.cronogramacapilar.data.DataBaseDao
import com.amandarezende.cronogramacapilar.telas.HomeScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var dao: DataBaseDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}