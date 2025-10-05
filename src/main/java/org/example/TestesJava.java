package org.example;

import java.util.ArrayList;
import java.util.List;

public class TestesJava {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);

        int x = 5;
        System.out.println(x++);

        String s = "Java"; System.out.println(s.substring(1, 3));
    }
}
