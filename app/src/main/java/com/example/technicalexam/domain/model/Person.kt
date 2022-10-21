package com.example.technicalexam.domain.model

data class Person(
    val adult: Boolean? = null,
    val gender: Int? = null,
    val id: Int? = null,
    val knownFor: ArrayList<KnownFor> = arrayListOf(),
    val knowForDepartment: String? = null,
    val name: String? = null,
    val popularity: Double = 0.0,
    val profilePath: String? = null
)
