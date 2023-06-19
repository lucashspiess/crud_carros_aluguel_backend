package br.ueg.prog.webi.faculdade.crud.service;

import br.ueg.prog.webi.faculdade.crud.model.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente incluir(Cliente cliente);
    Cliente alterar(Cliente cliente, Long id);
    Cliente excluir(Long id);
    Cliente obterPeloId(Long id);
    Cliente obterPeloCpf(Long cpf);
    List<Cliente> listarTodos();
}
