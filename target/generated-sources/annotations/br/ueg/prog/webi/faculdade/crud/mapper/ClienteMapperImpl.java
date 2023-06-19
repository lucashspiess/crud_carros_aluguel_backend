package br.ueg.prog.webi.faculdade.crud.mapper;

import br.ueg.prog.webi.faculdade.crud.dto.ClienteDTO;
import br.ueg.prog.webi.faculdade.crud.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-18T12:17:14-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Amazon.com Inc.)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public Cliente toModel(ClienteDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setId( dto.getId() );
        cliente.setNome( dto.getNome() );
        cliente.setCpf( dto.getCpf() );
        cliente.setEmail( dto.getEmail() );

        return cliente;
    }

    @Override
    public ClienteDTO toDTO(Cliente modelo) {
        if ( modelo == null ) {
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setId( modelo.getId() );
        clienteDTO.setNome( modelo.getNome() );
        clienteDTO.setCpf( modelo.getCpf() );
        clienteDTO.setEmail( modelo.getEmail() );

        return clienteDTO;
    }

    @Override
    public List<ClienteDTO> toDTO(List<Cliente> lista) {
        if ( lista == null ) {
            return null;
        }

        List<ClienteDTO> list = new ArrayList<ClienteDTO>( lista.size() );
        for ( Cliente cliente : lista ) {
            list.add( toDTO( cliente ) );
        }

        return list;
    }
}
