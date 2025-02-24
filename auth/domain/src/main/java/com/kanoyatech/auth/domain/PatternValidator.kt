package com.kanoyatech.auth.domain

interface PatternValidator {
    fun matches(value: String) : Boolean
}