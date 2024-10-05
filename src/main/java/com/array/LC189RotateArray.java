package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC189RotateArray {

    public static void main(String[] args) {
       int[] nums = {1,2,3,4,5,6,7};
       int k = 3;
       LC189RotateArray rotateArray = new LC189RotateArray();
       rotateArray.rotate(nums,k);
       Arrays.stream(nums).forEach(System.out::println);
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int d = k%n;
        if(d>n){
            return;
        }
        int start = 0;
        int end = n-d-1;

        while(start<=end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end]=temp;
            start++;
            end--;
        }

         start = n-d;
         end = n-1;
        while(start<=end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end]=temp;
            start++;
            end--;
        }

        start = 0;
        end = n-1;

        while(start<=end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }

    public void rotateBrute(int[] nums, int k) {
        int n = nums.length;
        int d = k%n;

       if(d>n)
           return;

       List<Integer> lst = new ArrayList<>();
       for(int i=n-d;i<n;i++){
           lst.add(nums[i]);
       }

       for(int i=n-d-1;i>=0;i--){
           nums[i+d]=nums[i];
       }

       for(int i=0;i<d;i++){
           nums[i]=lst.get(i);
       }


    }
}
