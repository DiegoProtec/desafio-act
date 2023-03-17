package com.act.spa.repository

import com.act.spa.model.entity.CompraModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CompraRepository : JpaRepository<CompraModel, Long>