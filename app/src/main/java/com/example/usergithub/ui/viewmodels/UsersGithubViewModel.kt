package com.example.usergithub.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usergithub.data.model.Users
import com.example.usergithub.data.repositories.UsersGithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

sealed class UiState {
    object Loading : UiState()
    data class Success(val data: List<Users>): UiState()
    data class Failure(val error: Exception): UiState()
}

@HiltViewModel
class UsersGithubViewModel @Inject constructor(private val usersGithubRepository: UsersGithubRepository): ViewModel(){
    private val _uiState = MutableLiveData<UiState>()
    val uiState = _uiState

    fun getUsers() {
        viewModelScope.launch {
            try {
                val result = usersGithubRepository.getUsers()

                if (result.isSuccessful && !result.body().isNullOrEmpty()) {
                    result.body()?.let {
                        _uiState.value = UiState.Success(it)
                    }
                } else {
                    _uiState.value = UiState.Failure(Exception("Error getting users"))
                }
            } catch (error: Exception) {
                _uiState.value = UiState.Failure(error)
            }
        }
    }
}