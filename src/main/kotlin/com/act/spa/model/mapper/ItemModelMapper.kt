package com.act.spa.model.mapper

import com.act.spa.model.dto.request.ItemModelRequestDTO
import com.act.spa.model.entity.ItemModel
import com.act.spa.model.entity.ProdutoModel
import com.act.spa.repository.ProdutoRepository
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingConstants.ComponentModel.SPRING
import org.mapstruct.Named
import org.mapstruct.ReportingPolicy.IGNORE
import org.springframework.beans.factory.annotation.Autowired

@Mapper(unmappedTargetPolicy = IGNORE, componentModel = SPRING)
abstract class ItemModelMapper {

    @Autowired
    private lateinit var produtoRepository: ProdutoRepository

    @Mapping(source = "itemModelRequestDTO.codProduto", target = "produto", qualifiedByName = ["stringToProduto"])
    abstract fun convertToModel(itemModelRequestDTO: ItemModelRequestDTO): ItemModel

    @Named("stringToProduto")
    fun stringToProduto(codigo: String): ProdutoModel {
        val cliente = produtoRepository.buscaProdutoPorCodigo(codigo)
        if (cliente.isPresent) {
            return cliente.get()
        }
        throw Exception("Error ao desserializar o objeto: Produto não encontrado")
    }
}