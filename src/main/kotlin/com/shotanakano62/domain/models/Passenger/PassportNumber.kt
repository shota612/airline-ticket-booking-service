package com.shotanakano62.domain.models.Passenger

import java.util.regex.Pattern

class PassportNumber(private val value: String) {
    init {
        validatePassportNumber(value)
    }

    private fun validatePassportNumber(passportNumber: String) {
        val passportNumberRegex = "^[A-Z0-9]{8,9}$"
        val pattern = Pattern.compile(passportNumberRegex)
        if (!pattern.matcher(passportNumber).matches()) {
            throw IllegalArgumentException("Invalid passport number: $passportNumber")
        }
    }
}