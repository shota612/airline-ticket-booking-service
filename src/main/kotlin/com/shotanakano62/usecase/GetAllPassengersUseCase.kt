package com.shotanakano62.usecase

import com.shotanakano62.domain.models.Passenger.Passenger
import com.shotanakano62.domain.repositories.PassengerRepository

class GetAllPassengersUseCase(private val repository: PassengerRepository) {
    fun execute(): List<Passenger> {
        return repository.findAll()
    }
}