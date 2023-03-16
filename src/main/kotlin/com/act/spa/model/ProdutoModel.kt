package com.act.spa.model

import jakarta.persistence.*

@Entity
@Table(name = "TB_PRODUTO")
@SequenceGenerator(name = "SEQ_GENERATOR_PRODUTO", sequenceName = "SEQ_PRODUTO", allocationSize = 1)
class ProdutoModel(
        @Id
        @Column(name = "COD_PRODUTO", nullable = false)
        var codigo: String,
        @Column(name = "NOME_PRODUTO", nullable = false)
        var nome: String,
        @Column(name = "DESC_PRODUTO", nullable = false)
        var descricao: String,
        @Column(name = "PRECO_PRODUTO", nullable = false)
        var preco: Int,
        @Column(name = "QTD_PRODUTO", nullable = false)
        var quantidade: Int
) {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR_PRODUTO")
    @Column(name = "ID_PRODUTO")
    val id: Long = 0
}