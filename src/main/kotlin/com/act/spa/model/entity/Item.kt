package com.act.spa.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "TB_ITEM")
@SequenceGenerator(name = "SEQ_GENERATOR_ITEM", sequenceName = "SEQ_ITEM", allocationSize = 1)
class Item(
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "COD_COMPRA")
        val compra: Compra,
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "COD_PRODUTO")
        val produto: Produto,
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