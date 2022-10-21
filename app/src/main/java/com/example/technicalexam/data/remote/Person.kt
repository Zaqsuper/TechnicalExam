package com.example.technicalexam.data.remote

import com.google.gson.annotations.SerializedName

data class Person(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    @SerializedName("known_for")
    val knownFor: ArrayList<KnownFor> = arrayListOf(),
    @SerializedName("known_for_department")
    val knowForDepartment: String,
    val name: String,
    val popularity: Double,
    @SerializedName("profile_path")
    val profilePath: String
)
