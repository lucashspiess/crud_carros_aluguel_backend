package br.ueg.prog.webi.faculdade.crud.mapper;

import br.ueg.prog.webi.api.mapper.BaseMapper;
import br.ueg.prog.webi.faculdade.crud.dto.CarroDTO;
import br.ueg.prog.webi.faculdade.crud.model.Carro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarroMapper extends BaseMapper<Carro, CarroDTO> {

    @Override
    @Mapping(source = "tipo_nome", target = "tipo.nome")
    @Mapping(source = "tipo_id", target = "tipo.id")
    @Mapping(source = "imagem_id", target = "imagem.id")
    @Mapping(source = "imagem_path", target = "imagem.pathReference")
    Carro toModelo(CarroDTO carro);

    @Override
    @Mapping(source = "tipo.nome", target = "tipo_nome")
    @Mapping(source = "tipo.id", target = "tipo_id")
    @Mapping(source = "imagem.id", target = "imagem_id")
    @Mapping(source = "imagem.pathReference", target = "imagem_path")
    CarroDTO toDTO(Carro carro);
}
