package com.act.spa.model

import jakarta.persistence.*

@Entity
@Table(name = "TB_ITEM")
@SequenceGenerator(name = "SEQ_GENERATOR_ITEM", sequenceName = "SEQ_ITEM", allocationSize = 1)
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR_ITEM")
    @Column(name = "ID_ITEM")
    val id: Long = 0

}