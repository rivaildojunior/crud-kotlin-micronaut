package br.com.curso.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.swagger.v3.oas.annotations.responses.ApiResponse

@Controller("/hello")
class HelloController {

    @ApiResponse(
            responseCode = "201",
            description = "Bar object correctly created")
    @Get
    @Produces(MediaType.TEXT_PLAIN)
    fun olaMundo() = "Ola Mundo!!!!"

}