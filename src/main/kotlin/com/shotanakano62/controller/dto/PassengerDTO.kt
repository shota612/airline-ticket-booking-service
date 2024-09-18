package com.shotanakano62.controller.dto

import kotlinx.serialization.Serializable

@Serializable
data class PassengerDTO(
    val id: String,
    val firstName: String,
    val middleName: String?,
    val lastName: String,
    val email: String,
    val passwordHash: String,
    val passportNumber: String
)