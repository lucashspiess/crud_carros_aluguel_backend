package br.ueg.prog.webi.faculdade.crud.mapper;

import br.ueg.prog.webi.faculdade.crud.dto.AluguelDTO;
import br.ueg.prog.webi.faculdade.crud.model.Aluguel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface AluguelMapper {
    @Mapping(source = "cpf_cliente", target = "cliente.cpf")
    @Mapping(source = "carro_placa", target = "carro.placa")
    public Aluguel toModel(AluguelDTO dto);

    @Mapping(source = "cliente.cpf", target = "cpf_cliente")
    @Mapping(source = "carro.placa", target = "carro_placa")
    public AluguelDTO toDTO(Aluguel modelo);

    @Mapping(source = "cliente.cpf", target = "cpf_cliente")
    @Mapping(source = "carro.placa", target = "carro_placa")
    public List<AluguelDTO> toDTO(List<Aluguel> lista);
}
