package org.example;

import java.util.*;

public class PalavraUnicaPorDocumento {
    public static void main(String[] args) {
        String[] documentos = {
                "o rato roeu a  do rei de roma o",
                "o rei mandou chamar a rainha",
                "a rainha mandou flores para roma"
        };
        List<Integer> contagens = new ArrayList<>();

        for (String doc : documentos) {
            String[] palavras = doc.toLowerCase().split(" ");
            Set<String> unicas = new HashSet<>(Arrays.asList(palavras));
            List<String> ordenadas = new ArrayList<>(unicas);

            Collections.sort(ordenadas);
            contagens.add(ordenadas.size());
        }

        System.out.println(contagens);

    }
}
