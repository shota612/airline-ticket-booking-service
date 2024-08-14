package com.shotanakano62.domain.repositories

import com.shotanakano62.domain.models.Passenger.Passenger
import com.shotanakano62.domain.models.Passenger.PassengerId

interface PassengerRepository {
    fun findAll(): List<Passenger>
    fun findById()
    fun insert(passenger: Passenger): PassengerId
    fun update(passenger: Passenger)
}