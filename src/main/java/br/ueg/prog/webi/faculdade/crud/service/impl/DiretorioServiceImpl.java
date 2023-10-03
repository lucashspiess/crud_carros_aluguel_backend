package br.ueg.prog.webi.faculdade.crud.service.impl;

import br.ueg.prog.webi.faculdade.crud.service.DiretorioService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

@Service
public class DiretorioServiceImpl implements DiretorioService {

    @Override
    public void copiaDiretorio(String origem, String destino) {
        File from = new File(origem);
        File to = new File(destino);

        try {
            FileUtils.copyDirectory(from, to);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void excluirDiretorio(String caminho) {
        try {
            Files.walk(Path.of(caminho))
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
