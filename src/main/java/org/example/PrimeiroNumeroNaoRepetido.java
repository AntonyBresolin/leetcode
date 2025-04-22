package org.example;

import java.util.LinkedHashMap;
import java.util.Map;

public class PrimeiroNumeroNaoRepetido {
    public static void main(String[] args) {
        int[] numeros = {4, 5, 1, 2, 0, 4};

        Map<Integer, Integer> mapa = new LinkedHashMap<>();
        for (int num : numeros) {
            mapa.put(num, mapa.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : mapa.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("Primeiro número não repetido: " + entry.getKey());
                break;
            }
        }
    }
}
