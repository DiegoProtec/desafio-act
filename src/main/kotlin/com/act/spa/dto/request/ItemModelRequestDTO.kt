package com.act.spa.dto.request

data class ItemModelRequestDTO(
        var produto: ProdutoModelRequestDTO,
        var quantidade: Int,
        var precoTotal: Double
)
