package com.example.technicalexam.ui.profile

import com.example.technicalexam.domain.model.Person

data class GetPopularPeopleState(
    val isLoading: Boolean = false,
    val data: ArrayList<Person>? = null,
    val error: String = ""
)
