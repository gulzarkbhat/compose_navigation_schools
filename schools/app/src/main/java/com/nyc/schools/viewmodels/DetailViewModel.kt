package com.nyc.schools.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nyc.schools.data.models.SchoolDetail
import com.nyc.schools.data.repository.SchoolRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    private val _uiState2 = MutableStateFlow<SchoolDetailState>(SchoolDetailState.Loading)
    val uiState2: StateFlow<SchoolDetailState> = _uiState2

    fun getSchoolDetail(dbn: String) {
        viewModelScope.launch {
            when (val result = SchoolRepository().getSchoolDetail(dbn)) {
                SchoolDetailState.Failure -> {
                    _uiState2.update { SchoolDetailState.Failure }
                }

                is SchoolDetailState.Success -> {
                    _uiState2.update {
                        SchoolDetailState.Success(result.data)
                    }
                }

                else -> _uiState2.update { SchoolDetailState.Failure }
            }
        }
    }

    sealed class SchoolDetailState {
        data class Success(val data: List<SchoolDetail>) : SchoolDetailState()
        object Failure : SchoolDetailState()
        object Loading : SchoolDetailState()
    }
}