package com.toptop.provider.presentation.auth.login

import com.rickclephas.kmm.viewmodel.coroutineScope
import com.toptop.provider.data.model.common.TTException
import com.toptop.provider.data.remote.request.LoginRequest
import com.toptop.provider.data.util.onFailure
import com.toptop.provider.data.util.onSuccess
import com.toptop.provider.domain.AuthRepository
import com.toptop.provider.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LoginViewModel : BaseViewModel<LoginState, LoginEvent>(LoginState()), KoinComponent {

    private val authRepository by inject<AuthRepository>()

    override fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.ChangePhone -> onChangePhone(phone = event.value)
            LoginEvent.ToggleTerms -> onToggleTerms()
            LoginEvent.Login -> login()
            LoginEvent.Idle -> setIdle()
        }
    }

    private fun onChangePhone(phone: String) {
        if (phone.length > 9) return

        stateData.update {
            it.copy(
                phone = phone,
                isEnabled = phone.length == 9 && it.isTermsChecked
            )
        }
    }

    private fun onToggleTerms() {
        stateData.update {
            val isChecked = !it.isTermsChecked

            it.copy(
                isTermsChecked = isChecked,
                isEnabled = it.phone.length == 9 && isChecked
            )
        }
    }

    private fun login() {
        setLoading()

        val request = LoginRequest(
            phone = currentState.phone
        )

        viewModelScope.coroutineScope.launch {
            authRepository.login(request).collectLatest { state ->
                state onSuccess {
                    setSuccess(true)
                } onFailure {
                    setFailure(exception)
                }
            }
        }
    }

    private fun setLoading() {
        stateData.update { it.copy(isLoading = true) }
    }

    private fun setSuccess(isSuccess: Boolean) {
        stateData.update {
            it.copy(
                isLoading = false,
                isSuccess = isSuccess,
                exception = null
            )
        }
    }

    private fun setFailure(exception: TTException) {
        stateData.update {
            it.copy(
                isLoading = false,
                isSuccess = false,
                exception = exception
            )
        }
    }

    private fun setIdle() {
        stateData.update {
            it.copy(
                isLoading = false,
                isSuccess = false,
                exception = null
            )
        }
    }
}