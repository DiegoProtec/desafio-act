package com.act.spa.repository

import com.act.spa.model.ClienteModel
import com.act.spa.model.mapper.StringToCliente
import com.act.spa.model.mapper.StringToObject

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