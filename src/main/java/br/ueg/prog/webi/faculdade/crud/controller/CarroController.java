package br.ueg.prog.webi.faculdade.crud.controller;

import br.ueg.prog.webi.faculdade.crud.dto.CarroDTO;
import br.ueg.prog.webi.faculdade.crud.dto.CarroIncluirDTO;
import br.ueg.prog.webi.faculdade.crud.dto.CarroListaDTO;
import br.ueg.prog.webi.faculdade.crud.mapper.CarroMapper;
import br.ueg.prog.webi.faculdade.crud.model.Carro;
import br.ueg.prog.webi.faculdade.crud.service.CarroService;
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
@RequestMapping(path = "${app.api.base}/carro")
public class  CarroController {

    @Autowired
    private CarroMapper mapper;

    @Autowired
    private CarroService service;

    @GetMapping(path="/listar")
    @Operation(description = "Listagem Geral", responses = {
            @ApiResponse(responseCode = "200", description = "Listagem geral",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema())),
            @ApiResponse(responseCode = "404", description = "Registro náo encontrado",
                    content = @Content(mediaType = "application/json"))
    })
    public List<CarroListaDTO> listAll_carro(){
        List<Carro> carros = service.listarTodos();
        System.out.print(carros);
        return mapper.toDTO(carros);
    }

    @PostMapping
    @Operation(description = "Inclusão de carro")
    public Carro incluir_carro(@RequestBody CarroIncluirDTO carro){
        Carro carroIncluir = this.mapper.toModel(carro);

        carroIncluir = this.service.incluir(carroIncluir);

        return carroIncluir;
    }

    @PutMapping(path = "/{placa}")
    @Operation(description = "Método utilizado para alterar os dados de um carro")
    public CarroDTO alterar_carro(@RequestBody CarroIncluirDTO carro, @PathVariable(name = "placa") String placa){
        Carro pCarro = mapper.toModel(carro);
        Carro alterar = service.alterar(pCarro, placa);
        return mapper.toCarroDTO(alterar);
    }

    @DeleteMapping(path = "/{placa}")
    @Operation(description = "Método utilizado para remover uma entidiade pela placa informada", responses = {
            @ApiResponse(responseCode = "200", description = "Entidade Removida", content = @Content(mediaType = "application/json"))})
    public ResponseEntity<CarroDTO> remover_carro(@RequestBody @PathVariable(name = "placa")String placa){
        Carro carroExcluido = this.service.excluir(placa);
        return ResponseEntity.ok(mapper.toCarroDTO(carroExcluido));
    }

    @GetMapping(path = "/{placa}")
    @Operation(description = "Método para retornar um carro pela placa", responses = {
            @ApiResponse(responseCode = "200", description = "retornar um carro pela placa",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(type = "array", anyOf = CarroDTO.class))),
            @ApiResponse(responseCode = "404", description = "Registro náo encontrado",
                    content = @Content(mediaType = "application/json"))
    })
    public CarroDTO obterPorPlaca(@PathVariable(name = "placa")String placa){
        Carro carro = this.service.obterCarroPelaPlaca(placa);
        return this.mapper.toCarroDTO(carro);
    }

    @PatchMapping(path = "/{placa}/alugar-carro", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Método utilizado para alugar um carro", responses = {
            @ApiResponse(responseCode = "200", description = "carro alugado", content = @Content(mediaType = "application/json", schema = @Schema(type = "array", anyOf = CarroDTO.class)))})
    public ResponseEntity<CarroDTO> alugar(@PathVariable(name = "placa")String placa){
        Carro carro = this.service.alugar(placa);
        return ResponseEntity.ok(this.mapper.toCarroDTO(carro));
    }

    @PatchMapping(path = "/{placa}/desalugar-carro", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Método utilizado para desalugar um carro", responses = {
            @ApiResponse(responseCode = "200", description = "carro devolvido", content = @Content(mediaType = "application/json", schema = @Schema(type = "array", anyOf = CarroDTO.class)))})
    public ResponseEntity<CarroDTO> desalugar(@PathVariable(name = "placa")String placa){
        Carro carro = this.service.desalugar(placa);
        return ResponseEntity.ok(this.mapper.toCarroDTO(carro));
    }
}
