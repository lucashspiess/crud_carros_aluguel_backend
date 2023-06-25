package br.ueg.prog.webi.faculdade.crud.service;

import br.ueg.prog.webi.faculdade.crud.model.Aluguel;
import br.ueg.prog.webi.faculdade.crud.model.Cliente;

import java.util.List;

public interface AluguelService {
    Aluguel incluir(String placa, Aluguel aluguel, Cliente cliente);
    Aluguel alterar(Aluguel aluguel, Long id);
    Aluguel excluir(Long id);
    List<Aluguel> listarTodos();
    Double calcularValorTotal(Aluguel aluguel, String placa);
    Aluguel obterPelaPlaca(String placa);
}
