package org.example;

import java.util.Arrays;

public class EstudoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;


        for(int i =(m-1); i < nums1.length-1; i++){
            System.out.println(nums2[i-n+1]);
            nums1[i+1] = nums2[i-n+1];
        }
        Arrays.sort(nums1);
        System.out.println(nums1);
    }

    private static void aaaa() {
        String str = "Java";
        str = str.concat(" Rocks");
        System.out.println(str);
    }

    private static void bestFormToDoAPalindrom() {
        int x = 10;
        if (x < 0 ) System.out.println("false");
        ;
        int newValue = 0;
        int aux = x;
        while(aux != 0){
            newValue = newValue*10 + aux%10;
            aux /= 10;
        }
        System.out.println(newValue);
        System.out.println(x);
    }

    private static void StringBuilder() {
        int x = 121;
        StringBuilder s = new StringBuilder(x+"");
        if(s.reverse().equals(x+"")) System.out.println("true");
        System.out.println(s.reverse());
        System.out.println(x+"");
        System.out.println("false");
    }

    private static void arrays() {
        // https://www.codewars.com/kata/5513795bd3fafb56c200049e/train/java
        int x=2;
        int n = 5;

        int[] arr = new int[n];
        for (int i =0; i<n; i++){
            arr[i] = 2*i;
        }

        System.out.println(arr);
    }
}
