package com.example.movieapiretrofit.api

import com.example.movieapiretrofit.model.CharacterList
import retrofit2.Response

class Repository {

    suspend fun getCharacters(page:Int): Response<CharacterList>{
        return RetrofitInstance.api.getCharacters(page)
    }

}