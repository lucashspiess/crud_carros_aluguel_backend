package br.ueg.prog.webi.faculdade.crud.utils;

public class ValidacoesComuns {
    public static boolean validarPlaca(String placa) {
        boolean placaValida = false;

        // Verifica se a placa está no formato correto
        if (placa.matches("[A-Z]{3}[0-9][0-9A-Z][0-9]{2}")) {

            // Verifica se a placa é do modelo antigo
            if (placa.matches("[A-Z]{3}-[0-9]{4}")) {
                return true;
            }

            // Verifica se a placa é do modelo Mercosul
            if (placa.matches("[A-Z]{3}[0-9][A-Z][0-9]{2}")) {
                int valor1 = placa.charAt(4) - '0';
                int valor2 = placa.charAt(5) - '0';
                int valor3 = placa.charAt(6) - '0';
                int valor4 = placa.charAt(7) - '0';
                int valor5 = placa.charAt(8) - '0';

                // Verifica se a placa atende aos critérios de validação estabelecidos pelo DENATRAN
                if ((valor1 * 10 + valor2) == ((valor3 * 10 + valor4) % 11) && valor5 == 1) {
                    return true;
                }
            }
        }

        return placaValida;
    }
}
