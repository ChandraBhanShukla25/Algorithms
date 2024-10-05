package com.recursion;

import java.util.Arrays;

public class MinimumAbsoluteSumDIffrenceLC2035 {

    public static void main(String[] args) {
        int[] nums = {2,-1,0,4,-2,-9};
        MinimumAbsoluteSumDIffrenceLC2035 minimum = new MinimumAbsoluteSumDIffrenceLC2035();
        int x = minimum.minimumDifference(nums);
        System.out.println(x);
    }

    public int minimumDifference(int[] arr) {
        int totalSum = Arrays.stream(arr).sum();
        return findMinimum(arr, totalSum, 0, 0);
    }

    private int findMinimum(int[] arr, int totalSum, int index, int sum) {
        if(index== arr.length){
            return Math.abs(sum - totalSum+sum);
        }
        int pick = findMinimum(arr, totalSum, index+1, sum+arr[index]);
        int notPick = findMinimum(arr,totalSum,index+1,sum);
        return Math.min(pick,notPick);
    }
}
