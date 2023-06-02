package br.ueg.prog.webi.faculdade.crud.service;

import br.ueg.prog.webi.faculdade.crud.model.Carro;

import java.util.List;

public interface CarroService {
    public Carro incluir (Carro carro);
    public Carro alterar (Carro carro, String placa);
    public Carro excluir(String placa);
    public Carro obterCarroPelaPlaca(String placa);
    public List<Carro> listarTodos();
    public Carro alugar(String placa);
    public Carro desalugar(String placa);
}