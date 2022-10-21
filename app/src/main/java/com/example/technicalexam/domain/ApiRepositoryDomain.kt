package com.example.technicalexam.domain

import com.example.technicalexam.data.remote.PopularPeopleResponse

interface ApiRepositoryDomain {
    suspend fun getPopularPeople(): PopularPeopleResponse
}