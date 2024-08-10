package com.example.orufyassignment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.orufyassignment.repository.MoviesRepository
import com.example.orufyassignment.viewModel.MovieViewModel

class MyViewModelFactory(private val repository: MoviesRepository) :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MovieViewModel::class.java))
        {
            return MovieViewModel(repository) as T
        }
        throw IllegalArgumentException("View Model Error")
    }
}