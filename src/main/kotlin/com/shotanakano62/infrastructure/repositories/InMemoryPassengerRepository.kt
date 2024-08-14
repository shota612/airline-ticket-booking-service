package com.shotanakano62.infrastructure.repositories

import com.shotanakano62.domain.models.Passenger.Passenger
import com.shotanakano62.domain.models.Passenger.PassengerId
import com.shotanakano62.domain.repositories.PassengerRepository

class InMemoryPassengerRepository: PassengerRepository {
    private val passengers = mutableListOf<Passenger>()

    override fun findAll(): List<Passenger> {
        return passengers
    }

    override fun findById() {
        TODO("Not yet implemented")
    }

    override fun insert(passenger: Passenger): PassengerId {
        passengers.add(passenger)
        return passenger.id
    }

    override fun update(passenger: Passenger) {
        TODO("Not yet implemented")
    }
}