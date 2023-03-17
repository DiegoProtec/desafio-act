package com.act.spa.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "TB_CLIENTE", uniqueConstraints = [UniqueConstraint(columnNames = ["LOGIN"])])
class ClienteModel(
    @Column(name = "NOME", nullable = false)
    var nome: String,
    @Column(name = "LOGIN", nullable = false)
    var login: String,
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    val compras: Array<CompraModel>
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CLIENTE")
    val id: Long = 0
}