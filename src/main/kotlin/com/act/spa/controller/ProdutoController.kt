package com.act.spa.controller

import com.act.spa.dto.response.ProdutoModelResponseDTO
import com.act.spa.service.ProdutoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/estoque-de-produtos")
@RestController
class ProdutoController(val produtoService: ProdutoService) {

    @GetMapping("/")
    fun listarProdutos(): ResponseEntity<List<ProdutoModelResponseDTO>> =
        produtoService.listarProdutos().let { ResponseEntity.ok(it) }

}