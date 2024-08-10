package com.example.orufyassignment.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val BASE_URL="https://api.themoviedb.org/3/"

    fun getInstance():APIService{
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit.create(APIService::class.java)
    }

}