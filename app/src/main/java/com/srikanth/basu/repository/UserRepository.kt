package com.srikanth.basu.repository

import com.srikanth.basu.api.UserService
import javax.inject.Inject

class UserRepository @Inject constructor(private val api: UserService) {
    suspend fun getAllUsers() = api.getAllUsers()
}