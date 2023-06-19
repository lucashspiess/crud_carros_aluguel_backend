package br.ueg.prog.webi.faculdade.crud.controller;

import br.ueg.prog.webi.faculdade.crud.dto.AluguelDTO;
import br.ueg.prog.webi.faculdade.crud.dto.ClienteDTO;
import br.ueg.prog.webi.faculdade.crud.mapper.ClienteMapper;
import br.ueg.prog.webi.faculdade.crud.model.Aluguel;
import br.ueg.prog.webi.faculdade.crud.model.Cliente;
import br.ueg.prog.webi.faculdade.crud.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "${app.api.base}/cliente")
public class ClienteController {

    @Autowired
    private ClienteMapper mapper;

    @Autowired
    private ClienteService service;

    @GetMapping(path="/listar")
    @Operation(description = "Listagem Geral", responses = {
            @ApiResponse(responseCode = "200", description = "Listagem geral",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema())),
            @ApiResponse(responseCode = "404", description = "Registro náo encontrado",
                    content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<List<ClienteDTO>> listAll_cliente(){
        List<Cliente> clientes = service.listarTodos();
        System.out.print(clientes);
        return ResponseEntity.ok(mapper.toDTO(clientes));
    }

    @PostMapping
    @Operation(description = "Inclusão de cliente")
    public Cliente incluir_cliente(@RequestBody ClienteDTO cliente){
        Cliente clienteIncluir = this.mapper.toModel(cliente);
        clienteIncluir.setId(0l);
        clienteIncluir = this.service.incluir(clienteIncluir);

        return clienteIncluir;
    }
    
    @PutMapping(path = "/{id}")
    @Operation(description = "Método utilizado para alterar os dados de um cliente")
    public ClienteDTO alterar_cliente(@RequestBody ClienteDTO cliente, @PathVariable(name = "id") Long id){
        Cliente pCliente = mapper.toModel(cliente);
        Cliente alterar = service.alterar(pCliente, id);
        return mapper.toDTO(alterar);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(description = "Método utilizado para remover um cliente pelo id informado", responses = {
            @ApiResponse(responseCode = "200", description = "Entidade Removida", content = @Content(mediaType = "application/json"))})
    public ResponseEntity<ClienteDTO> remover_cliente(@RequestBody @PathVariable(name = "id")Long id){
        Cliente clienteExcluido = this.service.excluir(id);
        return ResponseEntity.ok(mapper.toDTO(clienteExcluido));
    }

    @GetMapping(path = "/{id}")
    @Operation(description = "Método para retornar um cliente pelo id", responses = {
            @ApiResponse(responseCode = "200", description = "retornar um cliente pelo",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(type = "array", anyOf = ClienteDTO.class))),
            @ApiResponse(responseCode = "404", description = "Registro náo encontrado",
                    content = @Content(mediaType = "application/json"))
    })
    public ClienteDTO obterPorId_cliente(@PathVariable(name = "id")Long id){
        Cliente cliente = this.service.obterPeloId(id);
        return this.mapper.toDTO(cliente);
    }

    @GetMapping(path = "/cpf/{cpf}")
    @Operation(description = "Método para retornar um cliente pelo cpf", responses = {
            @ApiResponse(responseCode = "200", description = "retornar um cliente pelo cpf",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(type = "array", anyOf = ClienteDTO.class))),
            @ApiResponse(responseCode = "404", description = "Registro náo encontrado",
                    content = @Content(mediaType = "application/json"))
    })
    public ClienteDTO obterPorCpf_cliente(@PathVariable(name = "cpf")Long cpf){
        Cliente cliente = this.service.obterPeloCpf(cpf);
        return this.mapper.toDTO(cliente);
    }
}
