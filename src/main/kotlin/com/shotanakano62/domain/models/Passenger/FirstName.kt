package com.shotanakano62.domain.models.Passenger

class FirstName(private val value: String) {
    init {
        validate(value)
    }

    fun value(): String {
        return value
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is FirstName) return false
        return value == other.value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    private fun validate(value: String) {
        if (value.isBlank()) {
            throw IllegalArgumentException("First name must not be blank")
        }
    }
}