package com.act.spa.dto.request

data class ProdutoModelRequestDTO(
        var codigo: String,
        var nome: String,
        var descricao: String,
        var preco: Int,
        var quantidade: Int
)
