package com.example.movieapiretrofit.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapiretrofit.api.Repository
import com.example.movieapiretrofit.model.CharacterList
import kotlinx.coroutines.launch
import retrofit2.Response

class SharedViewModel(val repository: Repository): ViewModel() {

    var listCharacters = MutableLiveData<Response<CharacterList>>()

    fun getCharacters(page:Int){
        viewModelScope.launch {
            val characters = repository.getCharacters(page)
            listCharacters.value = characters
        }
    }



}
