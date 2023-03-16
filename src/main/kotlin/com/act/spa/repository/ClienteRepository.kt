package com.act.spa.repository

import com.act.spa.model.ClienteModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface ClienteRepository : JpaRepository<ClienteModel, Long> {
    fun buscaClienteByLogin(login: String): Optional<ClienteModel>

}