package br.ueg.prog.webi.faculdade.crud.mapper;

import br.ueg.prog.webi.faculdade.crud.dto.CarroDTO;
import br.ueg.prog.webi.faculdade.crud.dto.CarroIncluirDTO;
import br.ueg.prog.webi.faculdade.crud.dto.CarroListaDTO;
import br.ueg.prog.webi.faculdade.crud.model.Carro;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-20T14:03:24-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class CarroMapperImpl implements CarroMapper {

    @Override
    public CarroListaDTO toDTO(Carro carro) {
        if ( carro == null ) {
            return null;
        }

        CarroListaDTO carroListaDTO = new CarroListaDTO();

        carroListaDTO.setPlaca( carro.getPlaca() );
        carroListaDTO.setModelo( carro.getModelo() );
        carroListaDTO.setQuilometragem( carro.getQuilometragem() );
        carroListaDTO.setAno( carro.getAno() );
        carroListaDTO.setCor( carro.getCor() );
        carroListaDTO.setStatus( carro.getStatus() );

        return carroListaDTO;
    }

    @Override
    public List<CarroListaDTO> toDTO(List<Carro> carros) {
        if ( carros == null ) {
            return null;
        }

        List<CarroListaDTO> list = new ArrayList<CarroListaDTO>( carros.size() );
        for ( Carro carro : carros ) {
            list.add( toDTO( carro ) );
        }

        return list;
    }

    @Override
    public CarroIncluirDTO toCarroIncluirDTO(Carro carro) {
        if ( carro == null ) {
            return null;
        }

        CarroIncluirDTO carroIncluirDTO = new CarroIncluirDTO();

        carroIncluirDTO.setPlaca( carro.getPlaca() );
        carroIncluirDTO.setModelo( carro.getModelo() );
        carroIncluirDTO.setQuilometragem( carro.getQuilometragem() );
        carroIncluirDTO.setAno( carro.getAno() );
        carroIncluirDTO.setCor( carro.getCor() );

        return carroIncluirDTO;
    }

    @Override
    public Carro toModel(CarroIncluirDTO carro) {
        if ( carro == null ) {
            return null;
        }

        Carro carro1 = new Carro();

        carro1.setPlaca( carro.getPlaca() );
        carro1.setModelo( carro.getModelo() );
        carro1.setQuilometragem( carro.getQuilometragem() );
        carro1.setAno( carro.getAno() );
        carro1.setCor( carro.getCor() );

        return carro1;
    }

    @Override
    public CarroDTO toCarroDTO(Carro carro) {
        if ( carro == null ) {
            return null;
        }

        CarroDTO carroDTO = new CarroDTO();

        carroDTO.setPlaca( carro.getPlaca() );
        carroDTO.setModelo( carro.getModelo() );
        carroDTO.setQuilometragem( carro.getQuilometragem() );
        carroDTO.setAno( carro.getAno() );
        carroDTO.setCor( carro.getCor() );
        carroDTO.setStatus( carro.getStatus() );

        return carroDTO;
    }
}
