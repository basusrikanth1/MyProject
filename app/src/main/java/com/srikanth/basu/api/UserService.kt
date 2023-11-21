package com.srikanth.basu.api

import com.srikanth.basu.model.User

import com.srikanth.basu.utils.Constants.END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface UserService {
    @GET(END_POINT)
    suspend fun getAllUsers(): Response<User>
}