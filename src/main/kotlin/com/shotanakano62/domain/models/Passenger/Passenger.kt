package com.shotanakano62.domain.models.Passenger

data class Passenger(
    val id: String,
    val firstName: FistName,
    val middleName: String?,
    val lastName: LastName,
    val email: Email,
    val passwordHash: String,
    val passportNumber: PassportNumber
) {
    companion object {
        fun from(
            id: String,
            firstName: FistName,
            middleName: String?,
            lastName: LastName,
            email: Email,
            passwordHash: String,
            passportNumber: PassportNumber
        ): Passenger {
            return Passenger(
                id = id,
                firstName = firstName,
                middleName = middleName,
                lastName = lastName,
                email = email,
                passwordHash = passwordHash,
                passportNumber = passportNumber
            )
        }
    }
}
