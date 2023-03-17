package com.act.spa.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "TB_ITEM")
class ItemModel(
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "COD_COMPRA")
        var compra: CompraModel,
    @ManyToOne(cascade = [(CascadeType.PERSIST)], fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "COD_PRODUTO")
        var produto: ProdutoModel,
    @Column(name = "PRECO_ITEM", nullable = false)
        var precoTotal: Double,
    @Column(name = "QTD_PRODUTO", nullable = false)
        var quantidade: Int,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ITEM")
    val id: Long = 0
}