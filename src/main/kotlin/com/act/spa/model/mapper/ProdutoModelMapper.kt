package com.act.spa.model.mapper

import com.act.spa.model.dto.ProdutoModelDTO
import com.act.spa.model.entity.ProdutoModel
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants.ComponentModel.SPRING
import org.mapstruct.ReportingPolicy.IGNORE

@Mapper(unmappedTargetPolicy = IGNORE, componentModel = SPRING)
abstract class ProdutoModelMapper {

    abstract fun convertToDTO(model: ProdutoModel): ProdutoModelDTO


    abstract fun convertToModel(dto: ProdutoModelDTO): ProdutoModel

}