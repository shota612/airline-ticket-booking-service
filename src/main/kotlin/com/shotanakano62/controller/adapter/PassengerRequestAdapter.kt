package com.shotanakano62.controller.adapter

import com.shotanakano62.controller.dto.PassengerDTO
import com.shotanakano62.domain.models.Passenger.Passenger

class PassengerRequestAdapter {
    fun toDTOList(passengers: List<Passenger>): List<PassengerDTO> =
        passengers.map { toDTO(it) }

    private fun toDTO(passenger: Passenger): PassengerDTO =
        PassengerDTO(
            id = passenger.id.value.toString(),
            firstName = passenger.firstName.value(),
            middleName = passenger.middleName,
            lastName = passenger.lastName.value(),
            email = passenger.email.value(),
            passwordHash = passenger.passwordHash,
            passportNumber = passenger.passportNumber.value()
        )
}