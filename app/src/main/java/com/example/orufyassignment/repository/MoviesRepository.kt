package com.example.orufyassignment.repository


import com.example.orufyassignment.dataModel.PopularMovieDataModel
import com.example.orufyassignment.network.RetrofitClient

class MoviesRepository {

    suspend fun getMoviesData(pageNumber:Int): PopularMovieDataModel {
        return RetrofitClient.getInstance().getMovieList(pageNumber)
    }
}


