package com.shotanakano62.domain.repositories

import com.shotanakano62.domain.models.Passenger.*
import com.shotanakano62.infrastructure.database.Passengers
import com.shotanakano62.infrastructure.repositories.PassengerRepositoryImpl
import junit.framework.TestCase
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.Test
import java.sql.Connection
import java.sql.DriverManager
import java.util.*
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.assertEquals
import kotlin.test.assertTrue


class PassengerRepositoryTest {

    private val sqlitePath = "jdbc:sqlite:file:test?mode=memory&cache=shared"
    private lateinit var passengerRepository: PassengerRepository

    private val passenger1 = Passenger.from(
        id = PassengerId.from(UUID.randomUUID()),
        firstName = FirstName("John"),
        middleName = "Doe",
        lastName = LastName("Smith"),
        email = Email("test@test.com"),
        passwordHash = "password",
        passportNumber = PassportNumber("A1234567")
    )

    private val passenger2 = Passenger.from(
        id = PassengerId.from(UUID.randomUUID()),
        firstName = FirstName("Michael"),
        middleName = "Doe",
        lastName = LastName("Johnson"),
        email = Email("test@test.com"),
        passwordHash = "password",
        passportNumber = PassportNumber("B1234567")
    )

    private val passenger3 = Passenger.from(
        id = PassengerId.from(UUID.randomUUID()),
        firstName = FirstName("Rachel"),
        middleName = "Doe",
        lastName = LastName("Parker"),
        email = Email("test@test.com"),
        passwordHash = "password",
        passportNumber = PassportNumber("C1234567")
    )

    @BeforeTest
    fun setUp() {

        DriverManager.getConnection(sqlitePath)
        Database.connect(sqlitePath)
        TransactionManager.manager.defaultIsolationLevel = Connection.TRANSACTION_SERIALIZABLE

        transaction {
            SchemaUtils.create(Passengers)
        }

        passengerRepository = PassengerRepositoryImpl()

        transaction {
            passengerRepository.insert(passenger1)
            passengerRepository.insert(passenger2)
            passengerRepository.insert(passenger3)
        }
    }

    @AfterTest
    fun tearDown() {
        transaction {
            SchemaUtils.drop(Passengers)
        }

        TransactionManager.closeAndUnregister(database = Database.connect(sqlitePath))
    }


    @Test
    fun `findAll should return all passengers`() {

        // When
        val passengers = passengerRepository.findAll()

        // Then
        assertEquals(3, passengerRepository.findAll().size)
        assertTrue(passengers.contains(passenger1))
        assertTrue(passengers.contains(passenger2))
        assertTrue(passengers.contains(passenger3))
    }
}

