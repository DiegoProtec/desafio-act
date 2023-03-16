package com.act.spa.model.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "TB_COMPRA")
@SequenceGenerator(name = "SEQ_GENERATOR_COMPRA", sequenceName = "SEQ_COMPRA", allocationSize = 1)
class Compra(
        @Column(name = "PRECO_COMPRA", nullable = false)
        val precoTotal: String,
        @Column(name = "DATA_COMPRA", nullable = false)
        val dataCompra: LocalDateTime = LocalDateTime.now(),
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "COD_CLIENTE")
        val cliente: Cliente
) {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR_COMPRA")
    @Column(name = "ID_COMPRA")
    val id: Long = 0

    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, mappedBy = "compra")
    private val _itens = mutableListOf<Item>()

    val itens get() = _itens.toList()

    fun addItem(item: Item) {
        _itens += item
    }

}