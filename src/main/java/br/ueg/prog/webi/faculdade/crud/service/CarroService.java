package br.ueg.prog.webi.faculdade.crud.service;

import br.ueg.prog.webi.faculdade.crud.model.Carro;

import java.util.List;

public interface CarroService {
    public Carro incluir (Carro carro);
    public Carro alterar (Carro carro, String placa);
    public void excluir(String id);

    public Carro obterCarroPelaPlaca(String placa);
    public List<Carro> listarTodos();
}