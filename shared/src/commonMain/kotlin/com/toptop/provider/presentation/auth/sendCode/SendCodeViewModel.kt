package com.toptop.provider.presentation.auth.sendCode

import com.toptop.provider.data.model.common.TTException
import com.toptop.provider.domain.AuthRepository
import com.toptop.provider.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SendCodeViewModel : BaseViewModel<SendCodeState, SendCodeEvent>(SendCodeState()),
    KoinComponent {

    private val authRepository by inject<AuthRepository>()

    override fun onEvent(event: SendCodeEvent) {
        when (event) {
            SendCodeEvent.SendCode -> sendCode()
        }
    }

    private fun sendCode() {
        setLoading()
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