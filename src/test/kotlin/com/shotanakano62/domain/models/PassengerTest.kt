package com.shotanakano62.domain.models

import com.shotanakano62.domain.models.Passenger.*
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull

class PassengerTest {

    val uuid = UUID.randomUUID()
    val firstName = FirstName("Daniel")
    val middleName = "Doe"
    val lastName = LastName("Smith")

    @Test
    fun `should create a valid passenger`() {
        val email = Email("test@example.com")
        val passportNumber = PassportNumber("A1234567")
        val passenger = Passenger.from(
            id = uuid,
            firstName = firstName,
            middleName = middleName,
            lastName = lastName,
            email = email,
            passwordHash = "password",
            passportNumber = passportNumber
        )

        assertNotNull(passenger)
        assertEquals(email, passenger.email)
        assertEquals(passportNumber, passenger.passportNumber)
    }

    @Test
    fun `should create a valid passenger with empty middleName`() {
        val email = Email("test@example.com")
        val passportNumber = PassportNumber("A1234567")
        val passenger = Passenger.from(
            id = uuid,
            firstName = firstName,
            middleName = null,
            lastName = lastName,
            email = email,
            passwordHash = "password",
            passportNumber = passportNumber
        )

        assertNotNull(passenger)
        assertEquals(email, passenger.email)
        assertEquals(passportNumber, passenger.passportNumber)
    }

    @Test
    fun `should throw an exception when creating a passenger with empty first name`() {
        val exception = (assertFailsWith <IllegalArgumentException> {
            Passenger.from(
                id = uuid,
                firstName =  FirstName(""),
                middleName = "",
                lastName = LastName(""),
                email = Email("invalid-email"),
                passwordHash = "password",
                passportNumber = PassportNumber("A12345678")
            )
        })

        assertEquals("First name must not be blank", exception.message)
    }

    @Test
    fun `should throw an exception when creating a passenger with empty last name`() {
        val exception = (assertFailsWith <IllegalArgumentException> {
            Passenger.from(
                id = uuid,
                firstName =  firstName,
                middleName = "",
                lastName = LastName(""),
                email = Email("invalid-email"),
                passwordHash = "password",
                passportNumber = PassportNumber("A12345678")
            )
        })

        assertEquals("Last name must not be blank", exception.message)
    }

    @Test
    fun `should throw an exception when creating a passenger with an invalid email`() {
        val exception = (assertFailsWith <IllegalArgumentException> {
            Passenger.from(
                id = uuid,
                firstName = firstName,
                middleName = middleName,
                lastName = lastName,
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
            Passenger.from(
                id = uuid,
                firstName = firstName,
                middleName = middleName,
                lastName = lastName,
                email = Email("test@example.com"),
                passwordHash = "password",
                passportNumber = PassportNumber("invalid-passport-number")
            )
        })
        assertEquals("Invalid passport number: invalid-passport-number", exception.message)
    }
}