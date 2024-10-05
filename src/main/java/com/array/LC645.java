package com.array;

import java.util.Arrays;

public class LC645 {
    public static int[] findErrorNums(int[] nums) {
       int duplicate = -1;

       for(int i=0;i<nums.length;i++){

           if (nums[Math.abs(nums[i]) - 1] < 0) duplicate = Math.abs(nums[i]);
           else nums[Math.abs(nums[i]) - 1] *= -1;
       }

       int missing = -1;
       for(int i=0;i<nums.length;i++){
           if(nums[i]>0){
               missing = i+1;
           }
       }

        System.out.println(duplicate);

       return new int[] {duplicate,missing};
    }

    public static void main(String[] args) {
        int arr[] = {1,1};
        int[] errorNums = findErrorNums(arr);
        Arrays.stream(errorNums).forEach(System.out::println);
    }
}
