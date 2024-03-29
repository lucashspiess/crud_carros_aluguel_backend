package br.ueg.prog.webi.faculdade.crud.service.impl;

import br.ueg.prog.webi.faculdade.crud.model.Carro;
import br.ueg.prog.webi.faculdade.crud.repository.CarroRepository;
import br.ueg.prog.webi.faculdade.crud.service.CarroService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CarroServiceImpl implements CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Override
    public Carro incluir(Carro carro) {
        this.validarCamposObrigatorios(carro);
        this.validaPlacaExistente(carro);
        this.prepararParaIncluir(carro);
        carro.setPlaca(carro.getPlaca().toUpperCase());
        carro.setImagem_id(carro.getImagem_id());
        Carro carroIncluido = this.gravarDados(carro);
        return carroIncluido;
    }

    private void prepararParaIncluir(Carro carro) {
        carro.setStatus("Disponível");
    }

    private Carro gravarDados(Carro carro) {
        return carroRepository.save(carro);
    }


    private void validaPlacaExistente(Carro carro) {
        Optional<Carro> carroDaPlaca =carroRepository.findByPlaca(carro.getPlaca());
        if(carroDaPlaca.isPresent()){
            throw new IllegalArgumentException("Placa já cadastrada no sistema");
        }
    }

    private void validarCamposObrigatorios(Carro carro) {
        if(Objects.isNull(carro)){
            throw new IllegalArgumentException("Entidade Carro deve ser preenchida");
        }
        List<String> camposVazios = new ArrayList<>();
        if(Strings.isEmpty(carro.getPlaca())){
            camposVazios.add("Placa");
        }
        if(Objects.isNull(carro.getQuilometragem())){
            camposVazios.add("Quilometragem");
        }
        if(Strings.isEmpty(carro.getCor())){
            camposVazios.add("Cor");
        }
        if(Strings.isEmpty(carro.getModelo())){
            camposVazios.add("Modelo");
        }
        if(Objects.isNull(carro.getAno())){
            camposVazios.add("Ano");
        }
        if(Objects.isNull(carro.getImagem_id())){
            camposVazios.add("Imagem id");
        }
        if(!camposVazios.isEmpty()){
            throw new IllegalArgumentException(
                    "Campos obrigatórios não preenchidos ("+
                            String.join(", ",camposVazios)+")"
            );
        }
    }

    @Override
    public Carro alterar(Carro carro, String placa) {
        this.validarCamposObrigatorios(carro);

        Carro carroBD = recuperarCarroOuGeraErro(placa);

        carro.setStatus(carroBD.getStatus());


        Carro save = carroRepository.save(carro);

        return save;
    }

    private Carro recuperarCarroOuGeraErro(String placa) {
        return carroRepository
                .findByPlaca(placa)
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                "Erro ao localizarr carro"
                        )
                );
    }

    private boolean verificaStatus(Carro carro){
        if(carro.getStatus().equals("Disponível")){
            return true;
        }
        return false;
    }
    @Override
    public Carro excluir(String placa) {
        Carro carroExcluir = this.recuperarCarroOuGeraErro(placa);
        if(!verificaStatus(carroExcluir)){
            throw new IllegalArgumentException("Não é possível remover o carro, pois está alugado");
        }
        this.carroRepository.delete(carroExcluir);
        return carroExcluir;
    }

    @Override
    public Carro obterCarroPelaPlaca(String placa) {
        return this.recuperarCarroOuGeraErro(placa);
    }

    @Override
    public List<Carro> listarTodos() {
        return carroRepository.findAll();
    }

    @Override
    public Carro alugar(String placa) {
        Carro carro = this.recuperarCarroOuGeraErro(placa);
        carro.setStatus("Alugado");
        Carro save = this.carroRepository.save(carro);
        return save;
    }
    @Override
    public Carro desalugar(String placa){
        Carro carro = this.recuperarCarroOuGeraErro(placa);
        carro.setStatus("Disponível");
        Carro save = this.carroRepository.save(carro);
        return save;
    }

    @Override
    public List<Carro> listarDisponiveis() {
        return this.carroRepository.findByStatus("Disponível").orElseThrow();
    }

    @Override
    public List<Carro> listarAlugados() {
        return this.carroRepository.findByStatus("Alugado").orElseThrow();
    }
}
