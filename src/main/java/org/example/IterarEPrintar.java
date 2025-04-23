package org.example;

import java.sql.Timestamp;

public class IterarEPrintar {
    public static void main(String[] args) {
        System.out.println("Timestamp: " + new Timestamp(System.currentTimeMillis()));
        /*
        Write a short program that prints each number from 1 to 100 on a new line.

        For each multiple of 3, print "Fizz" instead of the number.

        For each multiple of 5, print "Buzz" instead of the number.

        For numbers which are multiples of both 3 and 5, print "FizzBuzz" instead of the number.
         */

        for (long i = 1; i <= 100; i++) {
            boolean div3 = (i % 3 == 0);
            boolean div5 = (i % 5 == 0);

            if (div3 && div5) System.out.println("FizzBuzz");
            else if (div3) System.out.println("Fizz");
            else if (div5) System.out.println("Buzz");
            else System.out.println(i);
        }
        System.out.println("Timestamp: " + new Timestamp(System.currentTimeMillis()));
    }
}
