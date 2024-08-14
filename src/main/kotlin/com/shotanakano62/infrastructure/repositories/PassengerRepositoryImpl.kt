package com.shotanakano62.infrastructure.repositories

import com.shotanakano62.domain.models.Passenger.*
import com.shotanakano62.domain.repositories.PassengerRepository
import com.shotanakano62.infrastructure.database.Passengers
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class PassengerRepositoryImpl: PassengerRepository {
    override fun findAll(): List<Passenger> = transaction {
        Passengers.selectAll().map { rowToPassenger(it) }
    }

    override fun findById() {
        TODO("Not yet implemented")
    }

    override fun save(passenger: Passenger) {
        TODO("Not yet implemented")
    }

    private fun rowToPassenger(row: ResultRow): Passenger {
        return Passenger(
            id = row[Passengers.id].value,
            firstName = FirstName(row[Passengers.firstName]),
            middleName = row[Passengers.middleName],
            lastName = LastName(row[Passengers.lastName]),
            email = Email(row[Passengers.email]),
            passwordHash = row[Passengers.passwordHash],
            passportNumber = PassportNumber(row[Passengers.passportNumber])
        )
    }
}