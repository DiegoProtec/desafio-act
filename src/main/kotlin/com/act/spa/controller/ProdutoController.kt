package com.act.spa.controller

import com.act.spa.model.dto.ProdutoModelDTO
import com.act.spa.service.ProdutoService
import org.springframework.http.HttpStatus.*
import org.springframework.http.MediaType.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/estoque-de-produtos")
@RestController
class ProdutoController(val produtoService: ProdutoService) {

    @GetMapping("/listagem", produces = [APPLICATION_JSON_VALUE])
    fun listarProdutos(): ResponseEntity<List<ProdutoModelDTO>> = try {
        produtoService.listarProdutos().let { ResponseEntity.ok(it) }
    } catch (e: Exception) {
        ResponseEntity<List<ProdutoModelDTO>>(arrayListOf(), INTERNAL_SERVER_ERROR)
    }

    @PostMapping("/atualizar-produto", consumes = [APPLICATION_JSON_VALUE])
    fun atualizarProduto(@RequestBody dto: ProdutoModelDTO): ResponseEntity<ProdutoModelDTO> = try {
        ResponseEntity<ProdutoModelDTO>(produtoService.atualizarProduto(dto), CREATED)
    } catch (e: Exception) {
        ResponseEntity<ProdutoModelDTO>(dto, INTERNAL_SERVER_ERROR)
    }

}