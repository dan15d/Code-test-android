@file:OptIn(ExperimentalCoroutinesApi::class)

package com.dan15d.codetest.datasource

import com.dan15d.codetest.datasource.remote.UserApi
import com.dan15d.codetest.datasource.remote.model.Data
import com.dan15d.codetest.datasource.remote.model.UserServerResponse
import com.dan15d.codetest.domain.model.User
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.ArrayList

class UserRepositoryTest {

    @MockK
    private lateinit var userApi: UserApi

    private lateinit var userRepository: UserRepositoryImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        userRepository = UserRepositoryImpl(userApi)
    }

    @Test
    fun `getUsers returns flow of UserServerResponse when userApi returns data`() = runBlockingTest {
            // Mock userApi behavior
            val users = arrayListOf(Data(1, "name", "last", "email", ""))
            val expectedResponse = UserServerResponse(
                page = 1,
                perPage = 1,
                total = 1,
                totalPages = 1,
                data = users
            )
            coEvery { userApi.getUsers() } returns flow { emit(expectedResponse) }

            // Call the method to test
            val flow = userRepository.getUsers()

            // Verify the flow emits the expected data
            val results = flow.toList()
            assertEquals(1, results.size) // Expect one emission
            assertEquals(expectedResponse, results[0])
        }
}