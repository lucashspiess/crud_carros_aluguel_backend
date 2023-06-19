package br.ueg.prog.webi.faculdade.crud.mapper;

import br.ueg.prog.webi.faculdade.crud.dto.ClienteDTO;
import br.ueg.prog.webi.faculdade.crud.model.Cliente;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ClienteMapper {
    public Cliente toModel(ClienteDTO dto);
    public ClienteDTO toDTO(Cliente modelo);
    public List<ClienteDTO> toDTO(List<Cliente> lista);
}
