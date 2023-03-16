package com.act.spa.model

import jakarta.persistence.*

@Entity
@Table(name = "TB_CLIENTE", uniqueConstraints = [UniqueConstraint(columnNames = ["LOGIN"])])
@SequenceGenerator(name = "SEQ_GENERATOR_CLIENTE", sequenceName = "SEQ_CLIENTE", allocationSize = 1)
class ClienteModel(
    @Column(name = "NOME", nullable = false)
    var nome: String,
    @Column(name = "LOGIN", nullable = false)
    var login: String,
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    val compras: Array<CompraModel>
) {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR_CLIENTE")
    @Column(name = "ID_CLIENTE")
    val id: Long = 0
}