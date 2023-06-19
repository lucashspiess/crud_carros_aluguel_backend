package br.ueg.prog.webi.faculdade.crud.mapper;

import br.ueg.prog.webi.faculdade.crud.dto.AluguelDTO;
import br.ueg.prog.webi.faculdade.crud.model.Aluguel;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface AluguelMapper {
    public Aluguel toModel(AluguelDTO dto);
    public AluguelDTO toDTO(Aluguel modelo);
    public List<AluguelDTO> toDTO(List<Aluguel> lista);
}
