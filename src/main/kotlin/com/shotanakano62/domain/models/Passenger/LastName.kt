package com.shotanakano62.domain.models.Passenger

class LastName(private val value: String) {
    init {
        validate(value)
    }

    fun value(): String {
        return value
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is LastName) return false
        return value == other.value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    private fun validate(value: String) {
        if (value.isBlank()) {
            throw IllegalArgumentException("Last name must not be blank")
        }
    }
}