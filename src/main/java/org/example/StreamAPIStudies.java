package org.example;

import java.util.*;
import java.util.stream.Collectors;

class Pessoa {
    private String nome;
    private int idade;
    private double salario;
    private String cidade;

    public Pessoa(String nome, int idade, double salario, String cidade) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getSalario() {
        return salario;
    }

    public String getCidade() {
        return cidade;
    }

    @Override
    public String toString() {
        return String.format("%s, %d anos, R$ %.2f, %s", nome, idade, salario, cidade);
    }
}

public class StreamAPIStudies {
    public static void main(String[] args) {
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Antony", 24, 3500.00, "Curitiba"),
                new Pessoa("Paola", 29, 4800.50, "São Paulo"),
                new Pessoa("Pedro", 19, 1800.00, "Curitiba"),
                new Pessoa("Arthur", 34, 7500.00, "Rio de Janeiro"),
                new Pessoa("Maria", 41, 5200.75, "Belo Horizonte"),
                new Pessoa("João", 27, 3200.00, "Curitiba"),
                new Pessoa("Carla", 22, 2600.00, "São Paulo")
        );

        // Exemplo rápido de uso
//        pessoas.stream()
//                .filter(p -> p.getSalario() > 3000)
//                .map(Pessoa::getNome)
//                .sorted()
//                .forEach(System.out::println);

        /*
            Lista de Exercícios – Java Stream API
            1. Filtrar e listar
            Liste apenas as pessoas que moram em Curitiba.
            Liste apenas as pessoas com idade maior que 30 anos.
        */
        Long now = System.currentTimeMillis();

        // salvando lista com .collect
//        List<String> lista = pessoas.parallelStream()
//                .filter(pessoa -> pessoa.getCidade().equals("Curitiba"))
//                .map(pessoa -> pessoa.getNome())
//                .collect(Collectors.toList());

//        pessoas.stream()
//                .filter(pessoa -> pessoa.getCidade().equals("Curitiba"))
//                .map(Pessoa::getNome)
//                .forEach(System.out::println);

//        pessoas.stream()
//                .filter(pessoa -> pessoa.getCidade().equals("Curitiba"))
//                .filter(pessoa -> pessoa.getNome().equals("João"))
//                .map(Pessoa::getNome)
//                .forEach(System.out::println);
//
//        System.out.println(System.currentTimeMillis()-now);


        /*
            2. Ordenação
            Liste todas as pessoas ordenadas por nome (A–Z).
            Liste todas as pessoas ordenadas por salário (maior para menor).
         */

//        pessoas.stream()
//                .map(Pessoa::getNome)
//                .sorted()
//                .forEach(System.out::println);

        // Comparator
//        pessoas.stream()
//                .sorted((p1, p2) -> Double.compare(p2.getSalario(), p1.getSalario()))
//                .map(Pessoa::getNome)
//                .forEach(System.out::println);

        /*
            3. Mapeamento
            Liste apenas os nomes das pessoas em maiúsculas.
            Liste apenas a idade de cada pessoa.
         */
//        pessoas.stream()
//                .map(Pessoa::getNome)
//                .forEach(p -> {
//                    System.out.println(p.toUpperCase());
//                });
//        pessoas.stream()
//                .map(Pessoa::getIdade)
//                .forEach(System.out::println);


        /*
        4. Redução e estatísticas
            Calcule a média salarial do grupo.
            Calcule a soma das idades.
            Encontre a maior idade e a menor idade.
         */
//        double mediaSalarial = pessoas.stream()
//                .mapToDouble(Pessoa::getSalario)
//                .average()
//                .orElse(0.0);
//
//        System.out.println(mediaSalarial);

//        int sum = pessoas.stream()
//                .mapToInt(Pessoa::getIdade)
//                .sum();
//
//        System.out.println(sum);

//        int x = pessoas.stream()
//                .map(Pessoa::getIdade)
//                .max(Integer::compare)
//                .orElse(0);
//
//        int y = pessoas.stream()
//                .map(Pessoa::getIdade)
//                .min(Integer::compare)
//                .orElse(0);
//
//        System.out.println(y);


        /*
            5. Agrupamento
                Agrupe as pessoas por cidade.

                Conte quantas pessoas existem em cada cidade.
         */

//        Map<String, List<Pessoa>> pessoasPorCidade = pessoas.stream()
//                .collect(Collectors.groupingBy(Pessoa::getCidade));
//
//        pessoasPorCidade.forEach((cidade, lista) -> {
//            System.out.println(cidade + ":");
//            lista.forEach(System.out::println);
//        });
//        Map<String, Integer> p = pessoas.stream()
//                .collect(Collectors.groupingBy(Pessoa::getCidade));
//        pessoas.stream()
//                .map(Pessoa::getIdade)
//                .filter(idade -> idade > 20)
//                .collect(Collectors.toList());


//        Map<String, List<Pessoa>> contadorPorCidade = pessoas.stream()
//                .collect(Collectors.groupingBy(Pessoa::getCidade));
//
//        contadorPorCidade.forEach((cidade, lista) -> {
//            System.out.println(cidade + ": "+lista.size());
//        });

//        Map<String, Long> contadorPorCidade = pessoas.stream()
//                .collect(Collectors.groupingBy(Pessoa::getCidade, Collectors.counting()));
//
//        contadorPorCidade.forEach((cidade, quantidade) -> {
//            System.out.println(cidade+": "+ quantidade);
//        });

        /*
            6. Uso de anyMatch, allMatch, noneMatch
                Verifique se todas as pessoas ganham mais de R$ 2.000.

                Verifique se alguma pessoa tem mais de 40 anos.

                Verifique se ninguém mora em "Fortaleza".

         */
//        boolean valida = pessoas.stream()
//                .allMatch(pessoa -> pessoa.getSalario() > 2000);
//
//        System.out.println(valida);

//        boolean valida = pessoas.stream()
//                .anyMatch(pessoa -> pessoa.getIdade() > 40);
//
//        System.out.println(valida);

//        boolean valida = pessoas.stream()
//                .noneMatch(pessoa -> pessoa.getCidade().equals("Fortaleza"));
//
//        System.out.println(valida);

        /*
            7. Encadeamento de operações
                Liste os nomes das pessoas de Curitiba com salário acima de R$ 3.000, ordenados por salário.

                Liste os nomes das pessoas com idade entre 20 e 30 anos, em ordem alfabética.

         */

//        pessoas.stream()
//                .filter(pessoa -> pessoa.getSalario() > 3000)
//                .sorted(Comparator.comparing(Pessoa::getSalario).reversed())
//                .forEach(pessoa -> System.out.println(pessoa.getNome()+ ": "+ pessoa.getSalario()));

//        pessoas.stream()
//                .filter(pessoa -> pessoa.getIdade() >= 20 && pessoa.getIdade() <=30)
//                .sorted(Comparator.comparing(Pessoa::getNome).reversed())
//                .forEach(pessoa -> System.out.println(pessoa.getNome()+": "+pessoa.getIdade()));

        /*
            8. Operações com Optional
                Encontre a pessoa mais velha.

                Encontre a pessoa com o menor salário.
         */

//        Optional<Pessoa> x = pessoas.stream()
//                .max(Comparator.comparing(Pessoa::getIdade));
//
//        System.out.println(x.get().getNome()+": "+ x.get().getIdade());

//        Optional<Pessoa> x = pessoas.stream()
//                .min(Comparator.comparing(Pessoa::getSalario));
//
//        System.out.println(x.get().getSalario());

        /*
               9. Trabalhando com Collectors.joining
                Gere uma única string com todos os nomes separados por vírgula.
         */

//        String nome = pessoas.stream()
//                .map(Pessoa::getNome)
//                .collect(Collectors.joining(", "));
//
//        System.out.println(nome);


        /*
            10. Desafio Final
                Agrupe as pessoas por cidade e, para cada cidade, mostre:
                    Quantidade de pessoas.
                    Média salarial.
                    Nome da pessoa mais nova daquela cidade.
         */

        Map<String, List<Pessoa>> pessoasPorCidade =
                pessoas.stream()
                        .collect(Collectors.groupingBy(Pessoa::getCidade));

        pessoasPorCidade.forEach((cidade, lista) -> {
            System.out.println("cidade: " + cidade);
            System.out.println("Quantidade de pessoas: " + lista.size());
            System.out.println("Media Salarial: " + lista.stream()
                    .collect(Collectors.averagingDouble(Pessoa::getSalario))
            );
            System.out.println("Pessoa mais nova: " + lista.stream().min(Comparator.comparingDouble(Pessoa::getIdade))
                            .get().getNome());
        });
    }
}
