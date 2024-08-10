package com.example.orufyassignment.network

import com.example.orufyassignment.dataModel.PopularMovieDataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

 @GET("movie/popular?api_key=82d736ecfbbe4aac21ac55e749c39d3f")
 suspend fun getMovieList(@Query("page") page:Int): PopularMovieDataModel

}