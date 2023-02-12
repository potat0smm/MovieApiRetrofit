package com.example.movieapiretrofit.api

import com.example.movieapiretrofit.model.CharacterList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleApi {

    @GET("api/character")
    suspend fun getCharacters(@Query("page") page: Int): Response<CharacterList>

}