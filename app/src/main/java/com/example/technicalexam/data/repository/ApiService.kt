package com.example.technicalexam.data.repository

import com.example.technicalexam.data.remote.PopularPeopleResponse
import retrofit2.http.GET

interface ApiService {
    @GET("person/popular?api_key=34d399bf802ca9949f5de15de62c970c&language=en-US&page=1")
    suspend fun getPopularPeople(): PopularPeopleResponse
}