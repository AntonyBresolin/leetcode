package org.example;

import java.util.Arrays;
import java.util.List;

public class RepositorioClienteEmMemoriaAdapter implements RepositorioCliente {
    private final List<String> LISTA_NEGRA = Arrays.asList("Cliente Problematico", "Comprador Caloteiro");

    @Override
    public boolean isClienteNaListaNegra(String nomeCliente) {
        return LISTA_NEGRA.contains(nomeCliente);
    }
}
