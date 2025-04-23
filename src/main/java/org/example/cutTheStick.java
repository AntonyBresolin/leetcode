package org.example;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class cutTheStick {
    static class Result {

        /*
         * Complete the 'cutTheSticks' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        public static List<Integer> cutTheSticks(List<Integer> arr) {
            // Write your code here
            List<Integer> resultado = new ArrayList<>();
            while (!arr.isEmpty()) {
                resultado.add(arr.size());

                int menor = Collections.min(arr);

                List<Integer> novaLista = new ArrayList<>();
                for (int val : arr) {
                    if (val - menor > 0) {
                        novaLista.add(val - menor);
                    }
                }

                arr = novaLista;
            }
            return resultado;
        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> result = Result.cutTheSticks(arr);

            bufferedWriter.write(
                    result.stream()
                            .map(Object::toString)
                            .collect(joining("\n"))
                            + "\n"
            );

            bufferedReader.close();
            bufferedWriter.close();
        }
    }


}
