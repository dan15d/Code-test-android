package com.dan15d.codetest.ui.screens.user_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dan15d.codetest.domain.model.User
import com.dan15d.codetest.domain.usecases.GetUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserListViewModel (private val getUserUseCase: GetUserUseCase): ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state = _state.asStateFlow()


    fun getUsers(){
        viewModelScope.launch {
            _state.value = UiState(isLoading = true)
            getUserUseCase.execute().collect{
                _state.value = UiState(users = it)
            }
        }
    }

    data class UiState(
        val users: ArrayList<User> = ArrayList(),
        val isLoading: Boolean = false,
    )

}