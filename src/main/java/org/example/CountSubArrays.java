package org.example;

public class CountSubArrays {
    public static void main(String[] args) {
        int[] nums = {7,8,-3};
        int count = 0;

        int size = nums.length;
        for(int i =0; i<size; i++){
            for(int j= 1; j < size; j++){
                for(int k =1; k< size; k++){
                    if((nums[i] + nums[j]) == nums[k]/2) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
