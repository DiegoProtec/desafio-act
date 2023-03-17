package com.act.spa.service

import com.act.spa.model.dto.ProdutoModelDTO
import com.act.spa.model.mapper.ProdutoModelMapper
import com.act.spa.repository.ProdutoRepository
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProdutoService(val produtoRepository: ProdutoRepository) {

    val produtoModelMapper: ProdutoModelMapper =
        Mappers.getMapper(ProdutoModelMapper::class.java)

    @Transactional
    fun listarProdutos(): List<ProdutoModelDTO> =
        produtoRepository.findAll().map { produtoModelMapper.convertToDTO(it) }

    @Transactional
    fun atualizarProduto(dto: ProdutoModelDTO): ProdutoModelDTO = produtoModelMapper.convertToModel(dto)
        .let { produtoRepository.save(it) }
        .let { produto -> produtoRepository.findById(produto.id) }
        .let { produto ->
            if (produto.isPresent) produtoModelMapper.convertToDTO(produto.get())
            else throw Exception("Produto não cadastrado!!!")
        }
}