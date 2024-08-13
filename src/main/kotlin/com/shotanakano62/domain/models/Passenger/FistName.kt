package com.shotanakano62.domain.models.Passenger

class FistName(private val value: String) {
    init {
        validate(value)
    }

    private fun validate(value: String) {
        if (value.isBlank()) {
            throw IllegalArgumentException("First name must not be blank")
        }
    }
}