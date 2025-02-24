package com.kanoyatech.auth.data

import android.util.Patterns
import com.kanoyatech.auth.domain.PatternValidator

class EmailPatternValidator: PatternValidator {
    override fun matches(value: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(value).matches()
    }
}