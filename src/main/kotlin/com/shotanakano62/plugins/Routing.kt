package com.shotanakano62.plugins

import com.shotanakano62.controller.PassengerController
import com.shotanakano62.controller.adapter.PassengerRequestAdapter
import com.shotanakano62.infrastructure.repositories.PassengerRepositoryImpl
import com.shotanakano62.usecase.GetAllPassengersUseCase
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    val repository = PassengerRepositoryImpl()
    val getAllPassengersUseCase = GetAllPassengersUseCase(repository)
    val passengerRequestAdapter = PassengerRequestAdapter()
    val passengerController = PassengerController(getAllPassengersUseCase, passengerRequestAdapter)

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/passengers") {
            passengerController.getAllPassengers(call)
        }
    }
}
