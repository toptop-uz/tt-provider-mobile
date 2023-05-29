package com.toptop.provider.presentation.auth

import com.rickclephas.kmm.viewmodel.coroutineScope
import com.toptop.provider.data.model.common.TTException
import com.toptop.provider.data.remote.request.AuthRequest
import com.toptop.provider.data.util.onFailure
import com.toptop.provider.data.util.onSuccess
import com.toptop.provider.domain.AuthRepository
import com.toptop.provider.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AuthViewModel : BaseViewModel<AuthState, AuthEvent>(AuthState()), KoinComponent {

    private val authRepository by inject<AuthRepository>()

    override fun onEvent(event: AuthEvent) {
        when (event) {
            is AuthEvent.ChangePhone -> onChangePhone(phone = event.value)
            is AuthEvent.ChangeTerms -> onChangeTerms(isTermsChecked = event.isChecked)
            is AuthEvent.Auth -> auth()
        }
    }

    private fun onChangePhone(phone: String) {
        stateData.update {
            it.copy(
                phone = phone,
                isEnabled = it.isTermsChecked
            )
        }
    }

    private fun onChangeTerms(isTermsChecked: Boolean) {
        stateData.update {
            it.copy(
                isTermsChecked = isTermsChecked,
                isEnabled = isTermsChecked
            )
        }
    }

    private fun auth() {
        setLoading()

        viewModelScope.coroutineScope.launch {
            val request = AuthRequest(phone = currentState.phone)

            authRepository.auth(request).collectLatest { state ->
                state onSuccess {
                    setSuccess(data ?: false)
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
}