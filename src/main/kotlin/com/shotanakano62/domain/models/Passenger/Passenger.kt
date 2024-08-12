package com.shotanakano62.domain.models.Passenger

data class Passenger(
    val id: String,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val email: Email,
    val passwordHash: String,
    val passportNumber: PassportNumber
)
