package com.example.orufyassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.orufyassignment.repository.MoviesRepository
import com.example.orufyassignment.screen.MovieScreen
import com.example.orufyassignment.ui.theme.OrufyAssignmentTheme
import com.example.orufyassignment.viewModel.MovieViewModel

class MainActivity : ComponentActivity() {

    val movieViewModel:MovieViewModel by viewModels {
        MyViewModelFactory(MoviesRepository())
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrufyAssignmentTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                        MovieScreen(movieViewModel)
                }
            }
        }
    }
}
