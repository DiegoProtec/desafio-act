package com.act.spa.model.mapper

import com.act.spa.model.dto.request.CompraModelRequestDTO
import com.act.spa.model.entity.ClienteModel
import com.act.spa.model.entity.CompraModel
import com.act.spa.repository.ClienteRepository
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingConstants.ComponentModel.SPRING
import org.mapstruct.Named
import org.mapstruct.ReportingPolicy.IGNORE
import org.springframework.beans.factory.annotation.Autowired

@Mapper(unmappedTargetPolicy = IGNORE, componentModel = SPRING, uses = [ItemModelMapper::class])
abstract class CompraModelMapper {

    @Autowired
    private lateinit var clienteRepositoryMapper: ClienteRepository

    @Mapping(source = "login", target = "cliente", qualifiedByName = ["stringToCliente"])
    abstract fun convertToModel(dto: CompraModelRequestDTO): CompraModel

    @Named("stringToCliente")
    fun stringToCliente(title: String): ClienteModel {
        val cliente = clienteRepositoryMapper.buscaClienteByLogin(title)
        if (cliente.isPresent) {
            return cliente.get()
        }
        throw Exception("Error ao desserializar o objeto: Cliente não encontrado")
    }

}