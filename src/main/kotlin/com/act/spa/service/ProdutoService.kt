package com.act.spa.service

import com.act.spa.dto.response.ProdutoModelResponseDTO
import com.act.spa.model.mapper.ProdutoModelResponseMapper
import com.act.spa.repository.ProdutoRepository
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.sql.SQLException

@Service
class ProdutoService(val produtoRepository: ProdutoRepository) {

    val produtoModelResponseMapper: ProdutoModelResponseMapper =
        Mappers.getMapper(ProdutoModelResponseMapper::class.java)

    @Transactional(rollbackFor = [SQLException::class])
    fun listarProdutos(): List<ProdutoModelResponseDTO> =
        produtoRepository.findAll().map { produtoModelResponseMapper.convertToDTO(it) }
}