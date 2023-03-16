package com.act.spa.model.mapper

import com.act.spa.dto.response.ProdutoModelResponseDTO
import com.act.spa.model.ProdutoModel
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants.ComponentModel.SPRING
import org.mapstruct.ReportingPolicy.IGNORE

@Mapper(unmappedTargetPolicy = IGNORE, componentModel = SPRING)
interface ProdutoModelResponseMapper {

    fun convertToDTO(model: ProdutoModel): ProdutoModelResponseDTO

}