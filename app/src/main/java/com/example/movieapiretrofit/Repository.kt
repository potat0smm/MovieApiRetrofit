package com.example.movieapiretrofit

import retrofit2.Response

class Repository {

    suspend fun getCharacters(page:Int): Response<CharacterList>{
        return RetrofitInstance.api.getCharacters(page)
    }

}