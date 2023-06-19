package br.ueg.prog.webi.faculdade.crud.service.impl;

import br.ueg.prog.webi.faculdade.crud.model.Cliente;
import br.ueg.prog.webi.faculdade.crud.repository.ClienteRepository;
import br.ueg.prog.webi.faculdade.crud.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteServiceImpl implements ClienteService {


    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente incluir(Cliente cliente) {
        Cliente clienteIncluido = this.gravarDados(cliente);
        return clienteIncluido;
    }


    private Cliente gravarDados(Cliente cliente) {
        return clienteRepository.save(cliente);
    }


    @Override
    public Cliente alterar(Cliente cliente, Long id) {

        Cliente clienteBD = recuperarClienteOuGeraErro(id);
        cliente.setId(id);
        return this.gravarDados(cliente);
    }

    private Cliente recuperarClienteOuGeraErro(Long id) {
        return clienteRepository
                .findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                "Erro ao localizarr cliente"
                        )
                );
    }

    @Override
    public Cliente excluir(Long id) {
        Cliente clienteExcluir = this.recuperarClienteOuGeraErro(id);
        this.clienteRepository.delete(clienteExcluir);
        return clienteExcluir;
    }

    @Override
    public Cliente obterPeloId(Long id) {
        return this.recuperarClienteOuGeraErro(id);
    }

    @Override
    public Cliente obterPeloCpf(Long cpf) {
        return clienteRepository
                .findByCpf(cpf)
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                "Erro ao localizarr cliente"
                        )
                );
    }

    @Override
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

}

