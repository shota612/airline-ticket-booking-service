package com.shotanakano62.infrastructure.database

import org.jetbrains.exposed.dao.id.UUIDTable

object Passengers: UUIDTable() {
    val firstName = varchar("first_name", 50)
    val middleName = varchar("middle_name", 50).nullable()
    val lastName = varchar("last_name", 50)
    val email = varchar("email", 100)
    val passwordHash = varchar("password_hash", 64)
    val passportNumber = varchar("passport_number", 20)
}