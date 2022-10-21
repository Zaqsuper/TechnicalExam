package com.example.technicalexam.domain.use_cases

import com.example.technicalexam.domain.ApiRepositoryDomain
import com.example.technicalexam.ui.Constants
import com.example.technicalexam.ui.getArrayPeople
import com.example.technicalexam.ui.profile.GetPopularPeopleState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPopularPeopleUseCase @Inject constructor(
    private val api: ApiRepositoryDomain
) {
    operator fun invoke():
            Flow<GetPopularPeopleState> = flow {
        try {
            emit(GetPopularPeopleState(isLoading = true))
            val response = api.getPopularPeople()
            emit(GetPopularPeopleState(data = getArrayPeople(response.results)))
        } catch (e: HttpException) {
            emit(GetPopularPeopleState(error = Constants.GENERIC_ERROR))
        } catch (e: IOException) {
            emit(GetPopularPeopleState(error = Constants.GENERIC_ERROR))
        }
    }
}