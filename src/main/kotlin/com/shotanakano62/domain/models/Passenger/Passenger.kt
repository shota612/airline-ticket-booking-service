package com.shotanakano62.domain.models.Passenger

import java.util.UUID


data class Passenger(
    val id: UUID,
    val firstName: FirstName,
    val middleName: String?,
    val lastName: LastName,
    val email: Email,
    val passwordHash: String,
    val passportNumber: PassportNumber
) {
    companion object {
        fun from(
            id: UUID,
            firstName: FirstName,
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
