package com.dynamicprogramming;

import java.util.Arrays;

public class FrogJumpKDistance {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 10, 20,30};
        int[] arr1 = {10,50,10};
        int[] arr2 = {4};
        int k=4;
        int x = frogJump(arr.length-1, arr, k);
        int y = frogJump(arr1.length-1, arr1, k);
        int z = frogJump(arr2.length-1, arr2, k);
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }

    public static int frogJump(int n, int heights[], int  k){
        if(n==0){
            return 0;
        }
        int mm = Integer.MAX_VALUE;
        for(int j=1;j<k;j++){
            if(n-j>=0){
             int jump = frogJump(n-j, heights, k)+ Math.abs(heights[n]-heights[n-j]);
             mm = Integer.min(mm, jump);
            }
        }
        return mm;
    }
}
