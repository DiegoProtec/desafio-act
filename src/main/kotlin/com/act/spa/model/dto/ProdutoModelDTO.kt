package com.act.spa.model.dto

data class ProdutoModelDTO(
    var id: Long?,
    var codigo: String,
    var nome: String,
    var descricao: String,
    var preco: Double,
    var quantidade: Int
)
