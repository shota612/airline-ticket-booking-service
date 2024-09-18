package com.shotanakano62.controller

import com.shotanakano62.controller.adapter.PassengerRequestAdapter
import com.shotanakano62.usecase.GetAllPassengersUseCase
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

class PassengerController(
    private val getAllPassengersUseCase: GetAllPassengersUseCase,
    private val passengerRequestAdapter: PassengerRequestAdapter
) {
    suspend fun getAllPassengers(call: ApplicationCall) {
        try {
            val passengers = getAllPassengersUseCase.execute()
            val passengersDTOs = passengerRequestAdapter.toDTOList(passengers)
            call.respond(HttpStatusCode.OK, passengersDTOs)
        } catch (e: Exception) {
            call.respond(HttpStatusCode.InternalServerError, "Failed to get passengers")
        }
    }
}