package com.example.movieapiretrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class SharedViewModel(val repository: Repository):ViewModel() {

    val listCharacters = MutableLiveData<Response<CharacterList>>()

    fun getCharacter(page:Int){
        viewModelScope.launch {
            val characters = repository.getCharacters(page)
            listCharacters.value = characters
        }
    }


}