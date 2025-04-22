package org.example;

import java.util.*;

public class TreinoHashMapSetELinkedHashMap {
    public static void main(String[] args) {
        String[] frases =
                {"o rato roeu a roupa do rei de roma o",
                "o rei mandou chamar a rainha",
                "a rainha mandou flores para roma"};

        List<Integer> contador = new ArrayList<>();


        for (String frase : frases) {
            String[] palavras = frase.split(" ");
            Map<String, Integer> counter = new HashMap<>();
            for (String palavra : palavras){
                counter.put(palavra, counter.getOrDefault(palavra, 0) +1);
            }
            int palavrasUnicas = 0;
            for (Map.Entry<String, Integer> pair : counter.entrySet()){
                if (pair.getValue() == 1) palavrasUnicas++;
            }
            contador.add(palavrasUnicas);
        }

        System.out.println(contador);
    }

    private static void contagemImpar() {
    /*
    🧩 10. Números com Contagem Ímpar
    Entrada: [1, 2, 2, 3, 3, 3, 4]
     Saída esperada: [1, 3] (aparecem número ímpar de vezes)
     Estrutura: Map<Integer, Integer>

     */

        int[] numeros = {1, 2, 2, 3, 3, 3, 4};

        Map<Integer, Integer> counter = new HashMap<>();

        for (int numero : numeros) {
            counter.compute(numero, (k, v) -> v == null ? 1 : v + 1);
        }

        Set<Integer> numeroImparDeVezes = new HashSet<>();
        counter.forEach((k, v) -> {
            if(v % 2 != 0) numeroImparDeVezes.add(k);
        });

        System.out.println(numeroImparDeVezes);
    }

    private static void palindromosUnicos() {
    /*
    🧩 9. Palíndromos Únicos
    Entrada: ["ovo", "arara", "casa", "reviver", "casa"]
     Objetivo: Retornar os palíndromos únicos encontrados.
     Estrutura: Set<String> + métudo auxiliar para verificar palíndromo

     */
        Set<String> palindromos = new HashSet<>();
        String[] palavras = {"ovo", "arara", "casa", "reviver", "casa"};

        for (String palavra : palavras) {
            boolean isPalindromo = true;
            for (int i = 0; i < palavra.length()/2; i++){
                if(palavra.charAt(i) != palavra.charAt(palavra.length() -i -1)) isPalindromo = false;
            }
            if (isPalindromo) palindromos.add(palavra);
        }

        System.out.println(palindromos);
    }

    private static void agrupadorPorLetraInicial() {
    /*
    🧩 8. Agrupar Palavras por Letra Inicial
        Entrada: ["cachorro", "cavalo", "gato", "girafa"]
         Saída esperada:
        java
        CopiarEditar
        {
          c: [cachorro, cavalo],
          g: [gato, girafa]
        }

        Estrutura: Map<Character, List<String>>

     */
        String[] animais = {"cachorro", "cavalo", "gato", "girafa"};
        Map<Character, List<String>> contador = new HashMap<>();

        for (String animal : animais){
            Character letra = animal.charAt(0);
            contador.computeIfAbsent(letra, k -> new ArrayList<>()).add(animal);
        }

        System.out.println(contador);
    }

    private static void removerDuplicadasPreservarOrdem() {
    /*
        🧩 7. Remover Duplicatas de Lista Preservando Ordem
        Entrada: [1, 3, 2, 1, 4, 2, 5]
         Saída esperada: [1, 3, 2, 4, 5]
         Estrutura: LinkedHashSet<Integer>

     */
        int[] numeros = {1, 3, 2, 1, 4, 2, 5};

        LinkedHashSet<Integer> lista = new LinkedHashSet<>();
        for (int numero : numeros) {
            lista.add(numero);
        }
        System.out.println(lista);
    }

    private static void palavrasUnicas() {
    /*
    🧩 6. Palavras Únicas em Frase
    Entrada: "o sol nasce para todos mas nem todos acordam com o sol"
     Objetivo: Retornar todas as palavras que aparecem apenas uma vez.
     Estrutura: Map<String, Integer> + List<String> para coletar únicas
     */

        String frase = "o sol nasce para todos mas nem todos acordam com o sol";
        String[] palavras = frase.split(" ");
        Map<String, Integer> contador = new HashMap<>();

        for(String palavra : palavras) {
            contador.put(palavra, contador.getOrDefault(palavra, 0) +1);
        }

        List<String> unicas = new ArrayList<>();
        for (Map.Entry<String, Integer> pair : contador.entrySet()){
            if(pair.getValue() == 1) unicas.add(pair.getKey());
        }

        System.out.println(unicas);
    }

    private static void intersecaoDoisArrays() {
    /*
     5. Interseção de Dois Arrays
        Entrada: [1, 2, 3, 4] e [3, 4, 5, 6]
         Saída esperada: [3, 4]
         Estrutura: Set<Integer>
     */
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {3, 4};

        Set<Integer> set1 = new HashSet<>();

        for (int i : array1){
            set1.add(i);
        }
        Set<Integer> repetidos = new HashSet<>();
        for (int i : array2){
            if (set1.contains(i)) repetidos.add(i);
        }

        System.out.println(repetidos);
    }

    private static void agrupadorDePalavras() {
    /*
    4. Agrupador de Palavras por Tamanho
        Entrada: ["casa", "sol", "ar", "lua", "vento"]
         Saída esperada:
        java
        CopiarEditar
        {
          2: [ar],
          3: [sol, lua],
          4: [casa],
          5: [vento]
        }

        Estrutura: Map<Integer, List<String>>

     */

        String[] palavras = {"casa", "sol", "ar", "lua", "vento"};
        Map<Integer, List<String>> agrupador = new HashMap<>();

        for(String palavra : palavras) {
            int tamanho = palavra.length();
            agrupador.computeIfAbsent(tamanho, k -> new ArrayList<>()).add(palavra);
        }
        // Por coincidencia está retornando ordenado, estudar stream para ordenação
        System.out.println(agrupador);
    }

    private static void primeiroCaracterNaoRepetido() {
    /*
     3. Primeiro Caractere Não Repetido
        Entrada: String "aabccdeff"
         Saída esperada: 'b'
         Estrutura: LinkedHashMap<Character, Integer>
     */

        String palavra = "aabccdeff";
        char[] letras = palavra.toCharArray();

        Map<Character, Integer> contadorCaracter = new LinkedHashMap<>();
        for (char letra : letras) {
            contadorCaracter.put(letra, contadorCaracter.getOrDefault(letra, 0) + 1);
        }

        for (Map.Entry<Character, Integer> pair : contadorCaracter.entrySet()){
            if (pair.getValue() == 1) {
                System.out.println(pair.getKey());
                break;
            }
        }
    }


    private static void palavrasRepetidas() {
    /*
    🧩 2. Palavras Repetidas
         Entrada: Lista de strings
         Objetivo: Liste as palavras que aparecem mais de uma vez.
         Estrutura: Map<String, Integer> + Set<String> (pra evitar duplicatas na saída)
     */
        List<String> frases = new ArrayList<>();
        frases.add("o rato roeu a  do rei de x");
        frases.add("o rei mandou chamar a rainha");
        frases.add("a rainha mandou flores para roma");

        Map<String, Integer> contadorPalavra = new HashMap<>();

        for(String frase : frases) {
            String[] palavras = frase.split(" ");
            for (String palavrasSeparadas :  palavras){
                contadorPalavra.put(palavrasSeparadas, contadorPalavra.getOrDefault(palavrasSeparadas, 0) +1);
            }
        }

        Set<String> palavras = new HashSet<>();
        for (Map.Entry<String, Integer> pair: contadorPalavra.entrySet()) {
            if (pair.getValue() != 1) {palavras.add(pair.getKey()); }
        }

        System.out.println(palavras);
    }

    private static void contadorCaracter() {
        /*
🧩       1. Frequência de Caracteres
             Entrada: String "banana"
             Objetivo: Conte quantas vezes cada caractere aparece.
             Estrutura: HashMap<Character, Integer>
         */

        String palavra = "banana";

        Map<Character, Integer> palavras = new HashMap<>();

        for (int i = 0; i < palavra.length(); i++) {
            palavras.put(palavra.charAt(i), palavras.getOrDefault(palavra.charAt(i), 0) + 1);
        }

        System.out.println(palavras);
    }


}
