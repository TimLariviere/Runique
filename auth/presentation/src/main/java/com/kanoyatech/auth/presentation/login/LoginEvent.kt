package com.kanoyatech.auth.presentation.login

import com.kanoyatech.core.presentation.ui.UiText

sealed interface LoginEvent {
    data class Error(val error: UiText): LoginEvent
    data object LoginSuccess: LoginEvent
}