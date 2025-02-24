package com.kanoyatech.auth.domain

data class PasswordValidationState(
    val hasMinLength: Boolean = false,
    val hasNumber: Boolean = false,
    val hasLowercaseCharacter: Boolean = false,
    val hasUppercaseCharacter: Boolean = false
) {
    val isValidPassword: Boolean
        get() = hasMinLength && hasNumber && hasLowercaseCharacter && hasUppercaseCharacter
}