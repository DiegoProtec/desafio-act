package com.act.spa.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "TB_PRODUTO", uniqueConstraints = [UniqueConstraint(columnNames = ["COD_PRODUTO"])])
class ProdutoModel(
        @Column(name = "COD_PRODUTO", nullable = false)
        var codigo: String,
        @Column(name = "NOME_PRODUTO", nullable = false)
        var nome: String,
        @Column(name = "DESC_PRODUTO", nullable = false)
        var descricao: String,
        @Column(name = "PRECO_PRODUTO", nullable = false)
        var preco: Double,
        @Column(name = "QTD_PRODUTO", nullable = false)
        var quantidade: Int
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PRODUTO")
    val id: Long = 0
}