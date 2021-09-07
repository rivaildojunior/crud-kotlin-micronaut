package br.com.curso.controller

import br.com.curso.model.Cliente
import br.com.curso.service.ClienteService
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

@Controller("/clientes")
class ClienteController(
      private val clienteService: ClienteService
) {

    @Post
    fun create(@Body cliente: Cliente): HttpResponse<Cliente> {
        val clienteDB = clienteService.create(cliente)
        return HttpResponse.created(clienteDB)
    }

    @Get
    fun findAll(@QueryValue nome: String?, pageable: Pageable): Page<Cliente>{
        return clienteService.findAll(nome, pageable)
    }

    @Get("/{id}")
    fun findById(@PathVariable id: Long): Cliente{
        return clienteService.findById(id)
    }

    @Delete("/{id}")
    fun delete(@PathVariable id: Long): HttpResponse<Unit>{
        clienteService.delete(id)
        return HttpResponse.noContent()
    }

    @Put("/{id}")
    fun update(@PathVariable id: Long, @Body cliente: Cliente){
        clienteService.update(id, cliente)

    }

    @Get("/pesquisar")
    fun listar(@QueryValue nome: String?): List<Cliente> {
        return clienteService.listar(nome)
    }
}