package com.act.spa.controller

import com.act.spa.dto.request.CompraModelRequestDTO
import com.act.spa.dto.response.CompraModelResponseDTO
import com.act.spa.service.CompraService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/compra")
@RestController
class CompraController(val compraService: CompraService) {

    @PostMapping("/")
    fun realizarCompra(
            @RequestBody compra: CompraModelRequestDTO): ResponseEntity<CompraModelResponseDTO> = compraService
            .comprar(compra)
            .let { dto -> ResponseEntity.ok(dto) }

}