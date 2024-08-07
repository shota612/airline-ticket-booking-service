package com.shotanakano62.domain.models

import java.time.LocalDateTime

data class Booking(
    val id: String,
    val flightId: String,
    val passengerId: String,
    val bookingTime: LocalDateTime,
    val seatNumber: String
)