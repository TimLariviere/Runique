package com.kanoyatech.auth.domain

class UserDataValidator(
    private val patternValidator: PatternValidator
) {

    fun isValidEmail(email: String): Boolean {
        return patternValidator.matches(email.trim())
    }

    fun validatePassword(password: String): PasswordValidationState {
        val hasMinLength = password.length >= MIN_PASSWORD_LENGTH
        val hasNumber = password.any { it.isDigit() }
        val hasLowercaseCharacter = password.any { it.isLowerCase() }
        val hasUppercaseCharacter = password.any { it.isUpperCase() }

        return PasswordValidationState(
            hasMinLength = hasMinLength,
            hasNumber = hasNumber,
            hasLowercaseCharacter = hasLowercaseCharacter,
            hasUppercaseCharacter = hasUppercaseCharacter
        )
    }

    companion object {
        const val MIN_PASSWORD_LENGTH = 9
    }
}