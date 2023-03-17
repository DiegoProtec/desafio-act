package com.act.spa.repository

import com.act.spa.model.entity.ProdutoModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProdutoRepository : JpaRepository<ProdutoModel, Long> {

    @Query("SELECT p FROM ProdutoModel p WHERE p.codigo = :codigo")
    fun buscaProdutoPorCodigo(@Param("codigo") codigo: String): Optional<ProdutoModel>

}