package com.dan15d.codetest.di

import com.dan15d.codetest.datasource.UserRepository
import com.dan15d.codetest.datasource.UserRepositoryImpl
import com.dan15d.codetest.datasource.remote.UserApi
import com.dan15d.codetest.domain.usecases.GetUserUseCase
import com.dan15d.codetest.ui.screens.user_list.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    single<UserApi> { UserApi() }

    single<UserRepository> { UserRepositoryImpl(get()) }

    single<GetUserUseCase> { GetUserUseCase(get()) }


    viewModel { UserListViewModel(get()) }
    viewModelOf(::UserListViewModel)
}