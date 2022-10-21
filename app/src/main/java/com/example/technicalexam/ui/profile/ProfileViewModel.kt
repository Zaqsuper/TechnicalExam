package com.example.technicalexam.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.technicalexam.domain.use_cases.GetPopularPeopleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getPopularPeopleUseCase: GetPopularPeopleUseCase
) : ViewModel() {
    private val _getPopularPeopleState = MutableLiveData<GetPopularPeopleState>()
    val getPopularPeopleState: LiveData<GetPopularPeopleState> get() = _getPopularPeopleState

    fun getPopularPeople() {
        getPopularPeopleUseCase().onEach { result ->
            _getPopularPeopleState.value = result
        }.launchIn(viewModelScope)
    }
}