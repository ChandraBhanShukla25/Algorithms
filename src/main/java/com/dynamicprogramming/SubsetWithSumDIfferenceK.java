package com.dynamicprogramming;

import java.util.Arrays;

public class SubsetWithSumDIfferenceK {

    public static void main(String[] args) {
         int[] arr = {5,2,6,4};
         int k =3;
         SubsetWithSumDIfferenceK subset = new SubsetWithSumDIfferenceK();
         int count = subset.findWays(arr, k);
         System.out.println(count);
    }

    public int findWays(int[] num, int target) {
        int total = Arrays.stream(num).sum();
        int findTotalWays = findTotalWays(num, target, total, 0,num.length-1);
        return findTotalWays;
    }

    private int findTotalWays(int[] num, int target, int total,int sum, int index) {
        if((total-(sum+sum))==target){
            return 1;
        }
        if(index<0){
            if((total-(sum+sum))==target)
                return 2;
            return 0;
        }

        int pick = 0;
        if(total-sum-sum>=target){
            pick = findTotalWays(num,target,total,sum+num[index], index-1);
        }
        int notPick = findTotalWays(num,target,total,sum, index-1);

        return pick+notPick;
    }
}
