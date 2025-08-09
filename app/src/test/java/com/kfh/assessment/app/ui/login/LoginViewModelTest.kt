package com.kfh.assessment.app.ui.login

import com.kfh.assessment.app.testing.MainDispatcherRule
import com.kfh.assessment.app.ui.common.UiState
import com.kfh.assessment.data.store.CredStore
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class LoginViewModelTest {

    @get:Rule
    val mainRule = MainDispatcherRule()

    @Test
    fun login_success_updates_state() = runTest {
        val store = mockk<CredStore>(relaxed = true)
        val validator: suspend (String, String) -> Unit = { _, _ -> /* success */ }
        val vm = LoginViewModel(store, validator)
        // add the username and the app password
        vm.login("username", "app_password")
        advanceUntilIdle()

        assertTrue(vm.state.value is UiState.Success)
        coVerify { store.save("Eslam_Code", "app_password") }
    }

    @Test
    fun login_401_sets_error() = runTest {
        val store = mockk<CredStore>(relaxed = true)
        val errorJson = "{\"error\":\"Unauthorized\"}"
        val body = errorJson.toResponseBody("application/json".toMediaType())
        val response = Response.error<Any>(401, body)
        val http401 = HttpException(response)

        // Mock validator that throws the 401 error
        val validator: suspend (String, String) -> Unit = { _, _ -> throw http401 }

        // Create the ViewModel with the mocked store and validator
        val vm = LoginViewModel(store, validator)

        // Attempt login with incorrect credentials
        vm.login("wrong", "wrong")

        // Wait until all coroutines finish
        advanceUntilIdle()

        // Get the current state of the ViewModel
        val state = vm.state.value

        // Print the state to the console
        println("Current state after login attempt: $state")

        // Verify that the state is indeed an error state
        assertTrue(state is UiState.Error)

        // Verify that no data was saved in the store
        coVerify(exactly = 0) { store.save(any(), any()) }
    }

}
