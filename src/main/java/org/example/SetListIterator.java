package org.example;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SetListIterator {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        set.add("cherry");

        System.out.println(set);

        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }

        Map<String, Integer> map = Map.of("apple", 1, "banana", 2, "cherry", 3);

        System.out.println(map);

    }
}
