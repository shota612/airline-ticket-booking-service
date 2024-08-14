package com.shotanakano62.domain.models.Passenger

class Email(private val value: String) {
    init {
        validateEmail(value)
    }

    fun value(): String {
        return value
    }

    private fun validateEmail(value: String) {
        if (!value.contains("@")) {
            throw IllegalArgumentException("Invalid email: $value")
        }
    }
}