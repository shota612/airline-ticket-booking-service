package com.shotanakano62.domain.models.Passenger

import java.util.UUID

data class Passengers (val list: List<Passenger>)

data class Passenger(
    val id: PassengerId,
    val firstName: FirstName,
    val middleName: String?,
    val lastName: LastName,
    val email: Email,
    val passwordHash: String,
    val passportNumber: PassportNumber
) {
    companion object {
        fun from(
            id: PassengerId,
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
