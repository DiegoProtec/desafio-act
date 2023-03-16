package com.act.spa.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "TB_COMPRA")
@SequenceGenerator(name = "SEQ_GENERATOR_COMPRA", sequenceName = "SEQ_COMPRA", allocationSize = 1)
class CompraModel(
    @Column(name = "PRECO_COMPRA", nullable = false)
    var precoTotal: String,
    @Column(name = "DATA_COMPRA", nullable = false)
    var dataCompra: LocalDateTime = LocalDateTime.now(),
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "COD_CLIENTE")
    var cliente: ClienteModel,
    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, mappedBy = "compra")
    val itens: Array<ItemModel>
) {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR_COMPRA")
    @Column(name = "ID_COMPRA")
    val id: Long = 0

}