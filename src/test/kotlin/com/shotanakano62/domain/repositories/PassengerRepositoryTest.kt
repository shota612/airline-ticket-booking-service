package com.shotanakano62.domain.repositories

import com.shotanakano62.domain.models.Passenger.*
import com.shotanakano62.infrastructure.repositories.InMemoryPassengerRepository
import org.junit.Before
import org.junit.Test
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertTrue


class PassengerRepositoryTest {

    private lateinit var passengerRepository: PassengerRepository
    val uuid = UUID.randomUUID()

    @Before
    fun setUp() {
        passengerRepository = InMemoryPassengerRepository()
    }

    val passenger1 = Passenger.from(
        id = uuid,
        firstName = FirstName("John"),
        middleName = "Doe",
        lastName = LastName("Smith"),
        email = Email("test@test.com"),
        passwordHash = "password",
        passportNumber = PassportNumber("A1234567")
    )

    val passenger2 = Passenger.from(
        id = uuid,
        firstName = FirstName("Michael"),
        middleName = "Doe",
        lastName = LastName("Johnson"),
        email = Email("test@test.com"),
        passwordHash = "password",
        passportNumber = PassportNumber("B1234567")
    )

    val passenger3 = Passenger.from(
        id = uuid,
        firstName = FirstName("Rachel"),
        middleName = "Doe",
        lastName = LastName("Parker"),
        email = Email("test@test.com"),
        passwordHash = "password",
        passportNumber = PassportNumber("C1234567")
    )

    @Test
    fun `findAll should return all passengers`() {
        // Given
        passengerRepository.save(passenger1)
        passengerRepository.save(passenger2)
        passengerRepository.save(passenger3)

        // When
        val passengers = passengerRepository.findAll()

        // Then
        assertEquals(3, passengerRepository.findAll().size)
        assertTrue(passengers.contains(passenger1))
        assertTrue(passengers.contains(passenger2))
        assertTrue(passengers.contains(passenger3))

    }
}