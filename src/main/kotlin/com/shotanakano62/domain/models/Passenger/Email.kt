package com.shotanakano62.domain.models.Passenger

class Email(private val value: String) {
    init {
        validateEmail(value)
    }

    fun value(): String {
        return value
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Email) return false
        return value == other.value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    private fun validateEmail(value: String) {
        if (!value.contains("@")) {
            throw IllegalArgumentException("Invalid email: $value")
        }
    }
}