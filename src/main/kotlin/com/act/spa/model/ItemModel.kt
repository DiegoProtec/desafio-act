package com.act.spa.model

import jakarta.persistence.*

@Entity
@Table(name = "TB_ITEM")
@SequenceGenerator(name = "SEQ_GENERATOR_ITEM", sequenceName = "SEQ_ITEM", allocationSize = 1)
class ItemModel(
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "COD_COMPRA")
        val compra: CompraModel,
        @ManyToOne(cascade = [(CascadeType.PERSIST)], fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "COD_PRODUTO")
        val produto: ProdutoModel,
        @Column(name = "QTD_PRODUTO", nullable = false)
        val quantidade: Int,
        @Column(name = "PRECO_ITEM", nullable = false)
        val precoTotal: Double
) {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR_ITEM")
    @Column(name = "ID_ITEM")
    val id: Long = 0

}