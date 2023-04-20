package br.ueg.prog.webi.faculdade.crud.controller;

import br.ueg.prog.webi.faculdade.crud.dto.CarroDTO;
import br.ueg.prog.webi.faculdade.crud.dto.CarroIncluirDTO;
import br.ueg.prog.webi.faculdade.crud.dto.CarroListaDTO;
import br.ueg.prog.webi.faculdade.crud.mapper.CarroMapper;
import br.ueg.prog.webi.faculdade.crud.model.Carro;
import br.ueg.prog.webi.faculdade.crud.service.CarroService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Operation(description = "Listagem geral de carros")
    public List<CarroListaDTO> listAll(){
        List<Carro> carros = service.listarTodos();
        return mapper.toDTO(carros);
    }

    @PostMapping
    @Operation(description = "Inclusão de carro")
    public Carro incluir(@RequestBody CarroIncluirDTO carro){
        Carro carroIncluir = this.mapper.toModel(carro);

        carroIncluir = this.service.incluir(carroIncluir);

        return carroIncluir;
    }

    @PutMapping(path = "/{placa}")
    @Operation(description = "Método utilizado para alterar os dados de um carro")
    public CarroDTO alterar(@RequestBody CarroIncluirDTO carro, @PathVariable(name = "placa") String placa){
        Carro pCarro = mapper.toModel(carro);
        Carro alterar = service.alterar(pCarro, placa);
        return mapper.toCarroDTO(alterar);
    }

    @DeleteMapping(path = "/{placa}")
    @Operation(description = "Método para remover um carro pela placa")
    public CarroDTO remover(@PathVariable(name = "placa")String placa){
        Carro carroExcluido = this.service.excluir(placa);
        return mapper.toCarroDTO(carroExcluido);
    }

    @GetMapping(path = "/{placa}")
    @Operation(description = "Método para retornar um carro pela placa")
    public CarroDTO obterPorPlaca(@PathVariable(name = "placa")String placa){
        Carro carro = this.service.obterCarroPelaPlaca(placa);
        return this.mapper.toCarroDTO(carro);
    }

    @PatchMapping(path = "/{placa}/alugar-carro")
    @Operation(description = "Método para mudar o status do carro para alugado")
    public CarroDTO alugar(@PathVariable(name = "placa")String placa){
        Carro carro = this.service.alugar(placa);
        return this.mapper.toCarroDTO(carro);
    }
}
