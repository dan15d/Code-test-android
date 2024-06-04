package com.dan15d.codetest.domain.usecases

import com.dan15d.codetest.datasource.UserRepository
import com.dan15d.codetest.datasource.UserRepositoryImpl
import kotlinx.coroutines.flow.map

class GetUserUseCase (private val repository: UserRepository){
    suspend fun execute() = repository.getUsers().map { it.toUserList() }
}