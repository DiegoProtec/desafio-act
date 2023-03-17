package com.act.spa.controller

import com.act.spa.model.dto.request.CompraModelRequestDTO
import com.act.spa.model.dto.response.CompraModelResponseDTO
import com.act.spa.service.CompraService
import org.springframework.http.MediaType.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/carrinho-de-compras")
@RestController
class CompraController(val compraService: CompraService) {

    @PostMapping("/salvar", consumes = [APPLICATION_JSON_VALUE])
    fun realizarCompra(
            @RequestBody compra: CompraModelRequestDTO
    ): ResponseEntity<CompraModelResponseDTO> = compraService
            .comprar(compra)
            .let { dto -> ResponseEntity.ok(dto) }

}