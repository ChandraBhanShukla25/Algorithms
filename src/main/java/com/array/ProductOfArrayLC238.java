package com.array;

import java.util.Arrays;

public class ProductOfArrayLC238 {

    public int[] productExceptSelf(int[] nums) {
       int n = nums.length;
       int result[] = new int[nums.length];
       result[0]=1;
       for(int i=1;i<n;i++){
           result[i] = result[i-1]*nums[i-1];
       }

       int R = 1;

       for(int i=n-1;i>=0;i--){
           result[i]=R*result[i];
           R=R*nums[i];
       }

      return result;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4};

        ProductOfArrayLC238 prod = new ProductOfArrayLC238();
        int result[] = prod.productExceptSelf(arr);
        Arrays.stream(result).forEach(System.out::println);
    }
}
