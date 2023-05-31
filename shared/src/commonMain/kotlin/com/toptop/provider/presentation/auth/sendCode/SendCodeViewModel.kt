package com.toptop.provider.presentation.auth.sendCode

import com.rickclephas.kmm.viewmodel.coroutineScope
import com.toptop.provider.data.model.common.TTException
import com.toptop.provider.data.remote.request.VerifyRequest
import com.toptop.provider.data.util.onFailure
import com.toptop.provider.data.util.onSuccess
import com.toptop.provider.domain.AuthRepository
import com.toptop.provider.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SendCodeViewModel : BaseViewModel<SendCodeState, SendCodeEvent>(SendCodeState()),
    KoinComponent {

    private val authRepository by inject<AuthRepository>()

    override fun onEvent(event: SendCodeEvent) {
        when (event) {
            is SendCodeEvent.ChangeCode -> onChangeCode(event.value)
            SendCodeEvent.ResendCode -> resendCode()
            SendCodeEvent.Idle -> setIdle()
        }
    }

    private fun onChangeCode(code: String) {
        stateData.update { it.copy(code = code) }

        if (code.length == 4 && currentState.type == SendCodeType.Timer) {
            verify(code)
        }
    }

    private fun resendCode() {
        onChangeCode("")
    }

    private fun verify(code: String) {
        setLoading()

        val request = VerifyRequest(code = code)

        viewModelScope.coroutineScope.launch {
            authRepository.verify(request).collectLatest { state ->
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
                code = "",
                isLoading = false,
                isSuccess = false,
                exception = exception
            )
        }
    }

    private fun setIdle() {
        stateData.update {
            it.copy(
                code = "",
                isLoading = false,
                isSuccess = false,
                exception = null
            )
        }
    }
}