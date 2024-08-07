package com.shotanakano62.domain.models

data class Passenger(
    val id: String,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val email: String,
    val passwordHash: String,
    val passportNumber: String
)
