package com.srikanth.basu.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.srikanth.basu.model.User
import com.srikanth.basu.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {
    private val _response = MutableLiveData<User>()
    val responseUsers: LiveData<User> get() = _response

    init {
        getAllUsers()
    }

    private fun getAllUsers() = viewModelScope.launch {
        repository.getAllUsers().let { response ->
            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                println("Error ${response.errorBody()}")
            }
        }
    }
}