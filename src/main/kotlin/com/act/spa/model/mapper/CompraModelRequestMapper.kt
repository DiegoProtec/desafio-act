package com.act.spa.model.mapper

import com.act.spa.dto.request.CompraModelRequestDTO
import com.act.spa.model.CompraModel
import org.mapstruct.Mapper
import org.mapstruct.Mapping


@Mapper(uses = [ClienteMap::class])
interface CompraModelRequestMapper {

    @Mapping(source = "login", target = "cliente", qualifiedBy = [StringToObject::class, StringToCliente::class])
    fun convertToModel(dto: CompraModelRequestDTO): CompraModel

}