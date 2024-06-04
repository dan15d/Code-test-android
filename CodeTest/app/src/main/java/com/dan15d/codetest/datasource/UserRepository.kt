package com.dan15d.codetest.datasource

import com.dan15d.codetest.datasource.remote.model.UserServerResponse
import com.dan15d.codetest.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUsers() : Flow<UserServerResponse>
}