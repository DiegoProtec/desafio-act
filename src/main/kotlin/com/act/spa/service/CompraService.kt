package com.act.spa.service

import com.act.spa.dto.request.CompraModelRequestDTO
import com.act.spa.dto.response.CompraModelResponseDTO
import com.act.spa.repository.CompraRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.sql.SQLException

@Service
class CompraService(val compraRepository: CompraRepository) {

    @Transactional(rollbackFor = [SQLException::class])
    fun comprar(compraModelRequestDTO: CompraModelRequestDTO): CompraModelResponseDTO {
        return CompraModelResponseDTO()
    }

}