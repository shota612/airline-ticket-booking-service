package com.shotanakano62.controller.adapter

import com.shotanakano62.domain.models.Passenger.*
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.util.*

class PassengerRequestAdapterTest {
    @Test fun `toDTO should return PassengerDTO`() {
        // Given
        val passengers = listOf(
            Passenger.from(
                id = PassengerId.from(UUID.randomUUID()),
                firstName = FirstName("John"),
                middleName = "Doe",
                lastName = LastName("Smith"),
                email = Email("test@hogehoge.com"),
                passwordHash = "password",
                passportNumber = PassportNumber("A1234567")
            ),
            Passenger.from(
                id = PassengerId.from(UUID.randomUUID()),
                firstName = FirstName("John"),
                middleName = "Doe",
                lastName = LastName("Smith"),
                email = Email("test@hogehoge.com"),
                passwordHash = "password",
                passportNumber = PassportNumber("A1234567")
            ),
        )
        // When
        val result = PassengerRequestAdapter().toDTOList(passengers)

        // Then
        assertEquals(passengers.size, result.size)
        passengers.forEachIndexed { index, passenger ->
            val dto = result[index]
            assertEquals(passenger.id.value, dto.id)
            assertEquals(passenger.firstName.value(), dto.firstName)
            assertEquals(passenger.middleName, dto.middleName)
            assertEquals(passenger.lastName.value(), dto.lastName)
            assertEquals(passenger.email.value(), dto.email)
            assertEquals(passenger.passwordHash, dto.passwordHash)
            assertEquals(passenger.passportNumber.value(), dto.passportNumber)
        }

    }
}