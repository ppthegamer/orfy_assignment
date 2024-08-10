package com.example.orufyassignment.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.orufyassignment.dataModel.PopularMovieDataModel
import com.example.orufyassignment.repository.MoviesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel(private val repository: MoviesRepository) : ViewModel() {


    private val _productsList = MutableStateFlow<List<PopularMovieDataModel>>(emptyList())
    val productsList: StateFlow<List<PopularMovieDataModel>> get() = _productsList
    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> get() = _isLoading


    fun getProducts(page: Int) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val data = repository.getMoviesData(page)
                _productsList.value = (_productsList.value + data).distinctBy { it.results[0].id }
                _isLoading.value = false
            } catch (e: Exception) {
                Log.e("Error", e.message.toString())
                _isLoading.value = false
            }finally {
                _isLoading.value = false
            }

        }
    }
}