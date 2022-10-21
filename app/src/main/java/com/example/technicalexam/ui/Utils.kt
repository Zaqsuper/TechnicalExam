package com.example.technicalexam.ui

import com.example.technicalexam.domain.model.KnownFor
import com.example.technicalexam.domain.model.Person
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

fun getApiClient(): OkHttpClient.Builder =
    OkHttpClient.Builder()
        .addInterceptor(getInterceptor())
        .retryOnConnectionFailure(false)

fun getInterceptor() = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

fun com.example.technicalexam.data.remote.Person.toPerson(): Person = Person(
    adult = adult,
    gender = gender,
    knownFor = getArrayKnownFor(knownFor),
    id = id,
    knowForDepartment = knowForDepartment,
    name = name,
    popularity = popularity,
    profilePath = profilePath
)

fun com.example.technicalexam.data.remote.KnownFor.toKnownFor(): KnownFor = KnownFor(
    overview = overview,
    posterPath = posterPath,
    releaseDate = releaseDate,
    title = title,
    voteAverage = voteAverage
)

fun getArrayKnownFor(knownFor: ArrayList<com.example.technicalexam.data.remote.KnownFor>): ArrayList<KnownFor> {
    val knownForList = ArrayList<KnownFor>()
    knownFor.forEach { knownForResponse ->
        knownForList.add(knownForResponse.toKnownFor())
    }
    return knownForList
}

fun getArrayPeople(results: ArrayList<com.example.technicalexam.data.remote.Person>): ArrayList<Person> {
    val peopleList = ArrayList<Person>()
    results.forEach { personResponse ->
        peopleList.add(personResponse.toPerson())
    }
    return peopleList
}