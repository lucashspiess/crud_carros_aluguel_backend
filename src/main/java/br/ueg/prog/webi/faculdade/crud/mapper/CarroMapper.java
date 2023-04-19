package br.ueg.prog.webi.faculdade.crud.mapper;

import br.ueg.prog.webi.faculdade.crud.dto.CarroDTO;
import br.ueg.prog.webi.faculdade.crud.dto.CarroIncluirDTO;
import br.ueg.prog.webi.faculdade.crud.dto.CarroListaDTO;
import br.ueg.prog.webi.faculdade.crud.model.Carro;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarroMapper {
    public CarroListaDTO toDTO(Carro carro);

    public List<CarroListaDTO> toDTO(List<Carro> carros);
    public CarroIncluirDTO toCarroIncluirDTO(Carro carro);

    public Carro toModel(CarroIncluirDTO carro);

    public CarroDTO toCarroDTO(Carro carro);
}
