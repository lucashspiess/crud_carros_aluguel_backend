package br.ueg.prog.webi.faculdade.crud.mapper;

import br.ueg.prog.webi.api.mapper.BaseMapper;
import br.ueg.prog.webi.faculdade.crud.dto.UsuarioDTO;
import br.ueg.prog.webi.faculdade.crud.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper extends BaseMapper<Usuario, UsuarioDTO> {
}

