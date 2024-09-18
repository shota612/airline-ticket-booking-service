package com.shotanakano62.infrastructure.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
    fun init() {
        val config = HikariConfig().apply {
            jdbcUrl = "jdbc:sqlite:./data.db"
            driverClassName = "org.sqlite.JDBC"
            maximumPoolSize = 3
            isAutoCommit = false
            transactionIsolation = "TRANSACTION_SERIALIZABLE"
            validate()
        }
        val dataSource = HikariDataSource(config)
        Database.connect(dataSource)

        transaction {
            SchemaUtils.create(Passengers)
        }
    }

    private fun insertPassengers() {
        transaction {
            Passengers.insert {
                it[firstName] = "John"
                it[middleName] = "Doe"
                it[lastName] = "Smith"
                it[email] = "john.smith@example.com"
                it[passwordHash] = "hashedpassword1"
                it[passportNumber] = "A1234567"
            }
            Passengers.insert {
                it[firstName] = "Jane"
                it[middleName] = "E."
                it[lastName] = "Doe"
                it[email] = "jane.doe@example.com"
                it[passwordHash] = "hashedpassword2"
                it[passportNumber] = "B1234568"
            }
        }
    }
}