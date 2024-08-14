package com.shotanakano62.domain.models.Passenger

class FirstName(private val value: String) {
    init {
        validate(value)
    }

    fun value(): String {
        return value
    }

    private fun validate(value: String) {
        if (value.isBlank()) {
            throw IllegalArgumentException("First name must not be blank")
        }
    }
}