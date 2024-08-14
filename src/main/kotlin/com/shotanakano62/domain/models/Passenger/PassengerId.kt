package com.shotanakano62.domain.models.Passenger

import java.util.*

data class PassengerId(val value: UUID)
{
    companion object {
        fun from(value: UUID): PassengerId {
            return PassengerId(value)
        }
    }
}