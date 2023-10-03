package br.ueg.prog.webi.faculdade.crud.service;

public interface DiretorioService {
    void copiaDiretorio(String origem, String destino);

    void excluirDiretorio(String caminho);
}
