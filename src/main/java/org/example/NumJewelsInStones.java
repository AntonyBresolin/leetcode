package org.example;

import java.util.HashMap;
import java.util.Map;

public class NumJewelsInStones {
    public static int returnNumJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> jewelsMap = new HashMap<>();
        int countFound = 0;
        for(char caracter : jewels.toCharArray()) {
            jewelsMap.put(caracter, 0);
        }
        for(char stone : stones.toCharArray()){
            if(jewelsMap.containsKey(stone)){ countFound++;}
        }

        return countFound;
    }
}
