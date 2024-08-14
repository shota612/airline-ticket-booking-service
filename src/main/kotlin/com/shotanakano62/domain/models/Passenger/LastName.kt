package com.shotanakano62.domain.models.Passenger

class LastName(private val value: String) {
    init {
        validate(value)
    }

    fun value(): String {
        return value
    }

    private fun validate(value: String) {
        if (value.isBlank()) {
            throw IllegalArgumentException("Last name must not be blank")
        }
    }
}