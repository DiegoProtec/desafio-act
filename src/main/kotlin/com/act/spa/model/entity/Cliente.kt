package com.act.spa.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "TB_CLIENTE")
@SequenceGenerator(name = "SEQ_GENERATOR_CLIENTE", sequenceName = "SEQ_CLIENTE", allocationSize = 1)
class Cliente(
        @Column(name = "NOME", nullable = false)
        val nome: String,
        @Column(name = "LOGIN", nullable = false)
        val login: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR_CLIENTE")
    @Column(name = "ID_CLIENTE")
    val id: Long = 0

    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, mappedBy = "cliente")
    private val _compras = mutableListOf<Compra>()

    val compras get() = _compras.toList()

    fun addCompra(compra: Compra) {
        _compras += compra
    }
}