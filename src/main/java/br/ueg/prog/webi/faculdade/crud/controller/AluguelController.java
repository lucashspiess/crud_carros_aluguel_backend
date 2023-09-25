package br.ueg.prog.webi.faculdade.crud.controller;

import br.ueg.prog.webi.faculdade.crud.dto.AluguelDTO;
import br.ueg.prog.webi.faculdade.crud.mapper.AluguelMapper;
import br.ueg.prog.webi.faculdade.crud.model.Aluguel;
import br.ueg.prog.webi.faculdade.crud.service.AluguelService;
import br.ueg.prog.webi.faculdade.crud.service.CarroService;
import br.ueg.prog.webi.faculdade.crud.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "${app.api.base}/aluguel")
public class AluguelController {

    @Autowired
    private AluguelMapper mapper;

    @Autowired
    private AluguelService service;
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CarroService carroService;

    @GetMapping(path = "/listar")
    @Operation(description = "Listagem Geral", responses = {
            @ApiResponse(responseCode = "200", description = "Listagem geral",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema())),
            @ApiResponse(responseCode = "404", description = "Registro náo encontrado",
                    content = @Content(mediaType = "application/json"))
    })
    public List<AluguelDTO> listAll_aluguel() {
        List<Aluguel> alugueis = service.listarTodos();
        System.out.print(alugueis);
        return mapper.toDTO(alugueis);
    }

    @PostMapping(path = "/{placa}/{cpf}")
    @Operation(description = "Inclusão de aluguel", responses = {
            @ApiResponse(responseCode = "200", description = "inclui um aluguel",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(type = "array", anyOf = AluguelDTO.class))),
            @ApiResponse(responseCode = "404", description = "Registro náo encontrado",
                    content = @Content(mediaType = "application/json"))
    })
    public Aluguel incluir_aluguel(@RequestBody AluguelDTO aluguel, @PathVariable(name = "placa")String placa, @PathVariable(name = "cpf") Long cpf) {
        Aluguel aluguelIncluir = this.mapper.toModel(aluguel);
        aluguelIncluir = this.service.incluir(carroService.obterCarroPelaPlaca(placa), aluguelIncluir, clienteService.obterPeloCpf(cpf));
        return aluguelIncluir;
    }

    @PutMapping(path = "/{id}")
    @Operation(description = "Método utilizado para alterar os dados de um aluguel")
    public AluguelDTO alterar_aluguel(@RequestBody AluguelDTO aluguel, @PathVariable(name = "id") Long id) {
        Aluguel pAluguel = mapper.toModel(aluguel);
        Aluguel alterar = service.alterar(pAluguel, id);
        return mapper.toDTO(alterar);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(description = "Método utilizado para remover um aluguel pelo id informado", responses = {
            @ApiResponse(responseCode = "200", description = "Entidade Removida", content = @Content(mediaType = "application/json"))})
    public ResponseEntity<AluguelDTO> remover_aluguel(@RequestBody @PathVariable(name = "id") Long id) {
        Aluguel aluguelExcluido = this.service.excluir(id);
        return ResponseEntity.ok(mapper.toDTO(aluguelExcluido));
    }

}

