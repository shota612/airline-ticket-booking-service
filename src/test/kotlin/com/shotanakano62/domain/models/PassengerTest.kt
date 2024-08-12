package com.shotanakano62.domain.models

import com.shotanakano62.domain.models.Passenger.Email
import com.shotanakano62.domain.models.Passenger.Passenger
import com.shotanakano62.domain.models.Passenger.PassportNumber
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull

class PassengerTest {

    @Test
    fun `should create a valid passenger`() {
        val email = Email("test@example.com")
        val passportNumber = PassportNumber("A1234567")
        val passenger = Passenger(
            id = "1",
            firstName = "Daniel",
            middleName = "Doe",
            lastName = "Smith",
            email = email,
            passwordHash = "password",
            passportNumber = passportNumber
        )

        assertNotNull(passenger)
        assertEquals(email, passenger.email)
        assertEquals(passportNumber, passenger.passportNumber)
    }

    @Test
    fun `should throw an exception when creating a passenger with an invalid email`() {
        val exception = (assertFailsWith <IllegalArgumentException> {
            Passenger(
                id = "1",
                firstName = "Daniel",
                middleName = "Doe",
                lastName = "Smith",
                email = Email("invalid-email"),
                passwordHash = "password",
                passportNumber = PassportNumber("A12345678")
            )
        })

        assertEquals("Invalid email: invalid-email", exception.message)
    }

    @Test
    fun `should throw an exception when creating a passenger with an invalid passport number`() {
        val exception = (assertFailsWith <IllegalArgumentException> {
            Passenger(
                id = "1",
                firstName = "Daniel",
                middleName = "Doe",
                lastName = "Smith",
                email = Email("test@example.com"),
                passwordHash = "password",
                passportNumber = PassportNumber("invalid-passport-number")
            )
        })
        assertEquals("Invalid passport number: invalid-passport-number", exception.message)
    }
}