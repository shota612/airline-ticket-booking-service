package com.shotanakano62.infrastructure.repositories

import com.shotanakano62.domain.models.Passenger.Passenger
import com.shotanakano62.domain.repositories.PassengerRepository

class InMemoryPassengerRepository: PassengerRepository {
    private val passengers = mutableListOf<Passenger>()

    override fun findAll(): List<Passenger> {
        return passengers
    }

    override fun findById() {
        TODO("Not yet implemented")
    }

    override fun save(passenger: Passenger) {
        passengers.add(passenger)
    }
}