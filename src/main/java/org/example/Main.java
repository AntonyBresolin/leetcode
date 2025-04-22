package org.example;


public class Main {
    public static void main(String[] args) {
        int sum = 0;
        String s = "LVIII";

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case 'M':
                    sum += 1000;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'C':
                    if (i + 1 < s.length() && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                        sum -= 100;
                    } else {
                        sum += 100;
                    }
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'X':
                    if (i + 1 < s.length() && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                        sum -= 10;
                    } else {
                        sum += 10;
                    }
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'I':
                    if (i + 1 < s.length() && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                        sum -= 1;
                    } else {
                        sum += 1;
                    }
                    break;
                default:
                    System.out.println("Invalid Roman numeral");
                    return;
            }
        }

        System.out.println(sum);
    }
}