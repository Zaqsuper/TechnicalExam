package com.example.technicalexam.data.repository

import com.example.technicalexam.data.remote.PopularPeopleResponse
import com.example.technicalexam.domain.ApiRepositoryDomain
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val api: ApiService
) : ApiRepositoryDomain {

    override suspend fun getPopularPeople()
            : PopularPeopleResponse = api.getPopularPeople()
}