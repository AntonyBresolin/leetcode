package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopLFrequent {
    public static void main(String[] args) {
        int[] nums= {1, 2, 2, 3, 3, 3};
        int k= 2;
        int[] newNums = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i =0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) +1);
        }

        List<Map.Entry<Integer, Integer>> lista = new ArrayList<>(map.entrySet());

        lista.sort(Map.Entry.comparingByValue());
        for(int i = 0; i < newNums.length; i++){
            newNums[i] = lista.get(lista.size()-i-1).getKey();
        }
    }
}
