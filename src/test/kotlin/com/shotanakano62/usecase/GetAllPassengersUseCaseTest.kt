package com.shotanakano62.usecase

import com.shotanakano62.domain.models.Passenger.*
import com.shotanakano62.domain.repositories.PassengerRepository
import com.shotanakano62.infrastructure.repositories.InMemoryPassengerRepository
import com.shotanakano62.infrastructure.repositories.PassengerRepositoryImpl
import junit.framework.TestCase.assertEquals
import java.util.*
import kotlin.test.BeforeTest
import kotlin.test.Test

class GetAllPassengersUseCaseTest {

    private lateinit var getAllPassengersUseCase: GetAllPassengersUseCase
    private lateinit var passengerRepository: PassengerRepository

    @BeforeTest
    fun setUp() {
        passengerRepository = InMemoryPassengerRepository()
        getAllPassengersUseCase = GetAllPassengersUseCase(passengerRepository)
    }

    @Test
    fun `should return all passengers`() {
        // Given
        val passenger1 = Passenger.from(
            id = PassengerId.from(UUID.randomUUID()),
            firstName = FirstName("John"),
            middleName = "Doe",
            lastName = LastName("Smith"),
            email = Email("john@example.com"),
            passwordHash = "password",
            passportNumber = PassportNumber("A1234567")
        )
        val passenger2 = Passenger.from(
            id = PassengerId.from(UUID.randomUUID()),
            firstName = FirstName("Jane"),
            middleName = "Doe",
            lastName = LastName("Doe"),
            email = Email("jane@example.com"),
            passwordHash = "password",
            passportNumber = PassportNumber("B1234567")
        )

        passengerRepository.insert(passenger1)
        passengerRepository.insert(passenger2)

        // When
        val actual = getAllPassengersUseCase.execute()

        // Then
        assertEquals(2, actual.size)
        assertEquals(passenger1, actual[0])
        assertEquals(passenger2, actual[1])
    }
}