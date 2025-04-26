package org.example;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9,8,7,6,5,4,3,2,1,0};
        long realValue = 0;
        for(int value : digits){
            realValue = (realValue*10)+value;
            System.out.println(realValue);
        }
        String x = String.valueOf(++realValue);
        System.out.println(x);
        int[] newVetor = new int[x.length()];
        for(int i = 0; i < x.length(); i++){
            newVetor[i] = Integer.parseInt(x.charAt(i)+"");
        }
    }
}
