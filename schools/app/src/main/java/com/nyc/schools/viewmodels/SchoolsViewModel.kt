package com.nyc.schools.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nyc.schools.data.models.School
import com.nyc.schools.data.repository.SchoolRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SchoolsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<SchoolState>(SchoolState.Loading)
    val uiState: StateFlow<SchoolState> = _uiState

    init {
        getSchools()
    }

    private fun getSchools() {
        viewModelScope.launch {
            when (val result = SchoolRepository().getSchools()) {
                SchoolState.Failure -> {
                    _uiState.update { SchoolState.Failure }
                }

                is SchoolState.Success -> {
                    _uiState.update { SchoolState.Success(result.data) }
                }

                else -> _uiState.update { SchoolState.Failure }
            }
        }
    }


    sealed class SchoolState {
        data class Success(val data: List<School>) : SchoolState()
        object Failure : SchoolState()
        object Loading : SchoolState()
    }
}