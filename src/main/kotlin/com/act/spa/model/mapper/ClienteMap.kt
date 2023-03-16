package com.act.spa.model.mapper

import com.act.spa.model.ClienteModel
import com.act.spa.repository.ClienteRepository

@StringToObject
class ClienteMap(private val clienteRepository: ClienteRepository) {

    @StringToCliente
    fun stringToCliente(title: String): ClienteModel {
        val cliente = clienteRepository.buscaClienteByLogin(title)
        if (cliente.isPresent) {
            return cliente.get()
        }
        throw Exception("Error ao desserializar o objeto")
    }
}