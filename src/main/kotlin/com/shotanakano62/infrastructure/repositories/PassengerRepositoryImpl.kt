package com.shotanakano62.infrastructure.repositories

import com.shotanakano62.domain.models.Passenger.*
import com.shotanakano62.domain.repositories.PassengerRepository
import com.shotanakano62.infrastructure.database.Passengers
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class PassengerRepositoryImpl: PassengerRepository {
    override fun findAll(): List<Passenger> = transaction {
        Passengers.selectAll().map { rowToPassenger(it) }
    }

    override fun findById() {
        TODO("Not yet implemented")
    }

    override fun insert(passenger: Passenger): PassengerId = transaction {
        val id = Passengers.insert {
            it[id] = passenger.id.value
            it[firstName] = passenger.firstName.value()
            it[middleName] = passenger.middleName
            it[lastName] = passenger.lastName.value()
            it[email] = passenger.email.value()
            it[passwordHash] = passenger.passwordHash
            it[passportNumber] = passenger.passportNumber.value()
        } get Passengers.id
        PassengerId.from(id.value)
    }

    override fun update(passenger: Passenger) {
        TODO("Not yet implemented")
    }

    private fun rowToPassenger(row: ResultRow): Passenger {
        return Passenger(
            id = PassengerId.from(row[Passengers.id].value),
            firstName = FirstName(row[Passengers.firstName]),
            middleName = row[Passengers.middleName],
            lastName = LastName(row[Passengers.lastName]),
            email = Email(row[Passengers.email]),
            passwordHash = row[Passengers.passwordHash],
            passportNumber = PassportNumber(row[Passengers.passportNumber])
        )
    }
}