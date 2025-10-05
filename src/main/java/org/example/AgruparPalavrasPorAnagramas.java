package org.example;

import java.util.*;

public class AgruparPalavrasPorAnagramas {

    public static Map<String, List<String>> agrupadorDeAnagramas(String[] palavras) {
        Map<String, List<String>> anagramas = new HashMap<>();

        for (String palavra : palavras) {
            char[] letras = palavra.toCharArray();
            Arrays.sort(letras);
            String chave = new String(letras);

            anagramas.putIfAbsent(chave, new ArrayList<>());
            anagramas.get(chave).add(palavra);
        }
        return anagramas;
    }
}
