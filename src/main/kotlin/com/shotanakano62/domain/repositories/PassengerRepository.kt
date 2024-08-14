package com.shotanakano62.domain.repositories

import com.shotanakano62.domain.models.Passenger.Passenger

interface PassengerRepository {
    fun findAll(): List<Passenger>
    fun findById()
    fun save(passenger: Passenger)
}