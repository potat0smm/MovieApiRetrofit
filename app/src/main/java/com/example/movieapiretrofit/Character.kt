package com.example.movieapiretrofit

data class Character(

    var id: Int,
    var name: String,
    var status: String,
    var species: String,
    var gender: String,
    var origin: LocationData,
    var locationData: LocationData,
    var image: String,
    var episode: List<String>
)
