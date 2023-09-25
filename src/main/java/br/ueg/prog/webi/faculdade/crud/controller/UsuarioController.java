package br.ueg.prog.webi.faculdade.crud.controller;

import br.ueg.prog.webi.api.controller.CrudController;
import br.ueg.prog.webi.api.exception.MessageResponse;
import br.ueg.prog.webi.faculdade.crud.dto.UsuarioDTO;
import br.ueg.prog.webi.faculdade.crud.mapper.UsuarioMapper;
import br.ueg.prog.webi.faculdade.crud.model.Usuario;
import br.ueg.prog.webi.faculdade.crud.service.impl.UsuarioServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/${app.api.version}/usuario")
public class UsuarioController extends CrudController<Usuario, UsuarioDTO, Long, UsuarioMapper, UsuarioServiceImpl> {


    @Override
    @PostMapping("/singup")
    public ResponseEntity<UsuarioDTO> incluir(UsuarioDTO modeloDTO) {
        return super.incluir(modeloDTO);
    }

    @Operation(
            description = "Obtendo Usuario por login",
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "UsuarioDTO  sendo obtido atraves do login",
                    content = {@Content(
                            mediaType = "application/json"
                    )}
            ), @ApiResponse(
                    responseCode = "404",
                    description = "Registro não encontrado",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = MessageResponse.class
                            )
                    )}
            )})
    @GetMapping(value = "obterPorlogin")
    public UsuarioDTO obterPorLogin(@RequestParam String username) {
        Usuario usuario = this.service.obterPeloLogin(username);
        return this.mapper.toDTO(usuario);
    }


}
