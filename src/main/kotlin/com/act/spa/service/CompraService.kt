package com.act.spa.service

import com.act.spa.dto.request.CompraModelRequestDTO
import com.act.spa.dto.response.CompraModelResponseDTO
import com.act.spa.model.mapper.CompraModelRequestMapper
import com.act.spa.repository.CompraRepository
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.sql.SQLException

@Service
class CompraService(val compraRepository: CompraRepository) {

    val compraModelRequestMapper: CompraModelRequestMapper = Mappers.getMapper(CompraModelRequestMapper::class.java)

    @Transactional(rollbackFor = [SQLException::class])
    fun comprar(compraModelRequestDTO: CompraModelRequestDTO): CompraModelResponseDTO = compraModelRequestMapper
            .convertToModel(compraModelRequestDTO)
            .let { compraRepository.save(it) }
            .let { CompraModelResponseDTO("Compra realizada com sucesso!") }

}