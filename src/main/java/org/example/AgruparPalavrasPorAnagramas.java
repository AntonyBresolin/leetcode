package org.example;

import java.util.*;

public class AgruparPalavrasPorAnagramas {

    public static void main(String[] args) {
        String[] palavras = {"roma", "amor", "casa", "saca", "mar", "ram"};

        Map<String, List<String>> anagramas = new HashMap<>();

        for (String palavra : palavras) {
            char[] letras = palavra.toCharArray();
            Arrays.sort(letras);
            String chave = new String(letras);

            anagramas.putIfAbsent(chave, new ArrayList<>());
            anagramas.get(chave).add(palavra);
        }

        System.out.println(anagramas);
    }
}
