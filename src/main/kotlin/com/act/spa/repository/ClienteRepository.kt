package com.act.spa.repository

import com.act.spa.model.entity.ClienteModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ClienteRepository : JpaRepository<ClienteModel, Long> {

    @Query("SELECT c FROM ClienteModel c WHERE c.login = :login")
    fun buscaClienteByLogin(@Param("login") login: String): Optional<ClienteModel>

}