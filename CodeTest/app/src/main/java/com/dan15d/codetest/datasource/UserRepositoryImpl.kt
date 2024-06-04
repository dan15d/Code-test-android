package com.dan15d.codetest.datasource

import com.dan15d.codetest.datasource.remote.UserApi
import com.dan15d.codetest.datasource.remote.model.UserServerResponse
import com.dan15d.codetest.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepositoryImpl (private val userApi: UserApi) : UserRepository{
    override suspend fun getUsers(): Flow<UserServerResponse> = userApi.getUsers()
}