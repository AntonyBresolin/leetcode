package org.example;

import java.util.HashMap;
import java.util.Map;

public class NumJewelsInStones {
    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";
        Map<Character, Integer> jewelsMap = new HashMap<>();
        int countFound = 0;
        for(char caracter : jewels.toCharArray()) {
            jewelsMap.put(caracter, 0);
        }
        for(char stone : stones.toCharArray()){
            if(jewelsMap.containsKey(stone)){ countFound++;}
        }

        System.out.println(countFound);
    }
}
