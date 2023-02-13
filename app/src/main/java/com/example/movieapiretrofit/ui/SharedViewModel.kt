package com.example.movieapiretrofit.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide.init
import com.example.movieapiretrofit.api.Repository
import com.example.movieapiretrofit.model.CharacterList
import kotlinx.coroutines.launch
import retrofit2.Response

class SharedViewModel(val repository: Repository): ViewModel() {

    var listCharacters = MutableLiveData<Response<CharacterList>>()
    var filterValue = MutableLiveData<Array<Int>>()
    var isFilter = MutableLiveData<Boolean>()

    init {
        filterValue.value = arrayOf(0, 0)
        isFilter.value = false
    }


    fun getCharacters(page:Int){
        viewModelScope.launch {
            val characters = repository.getCharacters(page)
            listCharacters.value = characters
            isFilter.value = false
        }
    }
    fun getByStatusAndGender(status: String,gender:String,page:Int){
        viewModelScope.launch {
            val characters = repository.getCharactersByStatusAndGender(status,gender,page)
            listCharacters.value = characters
            isFilter.value = true
        }
    }
    fun getByStatus(status: String,page:Int){
        viewModelScope.launch {
            val characters = repository.getCharactersByStatus(status,page)
            listCharacters.value = characters
            isFilter.value = true
        }
    }
    fun getByGender(gender:String,page:Int){
        viewModelScope.launch {
            val characters = repository.getCharactersByGender(gender,page)
            listCharacters.value = characters
            isFilter.value = true
        }
    }
    fun getByName(name:String){
        viewModelScope.launch {
            val character = repository.getCharactersByName(name)
            listCharacters.value = character
            isFilter.value = true
        }
    }




}
