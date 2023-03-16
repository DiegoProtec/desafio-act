package com.act.spa.dto.response

data class ProdutoModelResponseDTO(
    var codigo: String,
    var nome: String,
    var descricao: String,
    var preco: Double,
    var quantidade: Int
)
