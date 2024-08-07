package com.shotanakano62.domain.models

import java.time.LocalDateTime

data class Flight(
    val id: String,
    val flightNumber: String,
    val departureAirport: String,
    val arrivalAirport: String,
    val departureTime: LocalDateTime,
    val arrivalTime: LocalDateTime,
    val seatCapacity: Int,
    val availableSeats: Int
)