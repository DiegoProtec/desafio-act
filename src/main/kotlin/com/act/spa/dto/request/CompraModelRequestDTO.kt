package com.act.spa.dto.request

import java.time.LocalDateTime

data class CompraModelRequestDTO(
        var precoTotal: String,
        var dataCompra: LocalDateTime,
        var cliente: ClienteModelRequestDTO,
        var itens: Array<ItemModelRequestDTO>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CompraModelRequestDTO

        if (precoTotal != other.precoTotal) return false
        if (dataCompra != other.dataCompra) return false
        if (cliente != other.cliente) return false
        if (!itens.contentEquals(other.itens)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = precoTotal.hashCode()
        result = 31 * result + dataCompra.hashCode()
        result = 31 * result + cliente.hashCode()
        result = 31 * result + itens.contentHashCode()
        return result
    }
}