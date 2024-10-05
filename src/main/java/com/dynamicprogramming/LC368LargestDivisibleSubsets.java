package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC368LargestDivisibleSubsets {

    public static void main(String[] args) {
       int[] nums = {1,2,3};
       LC368LargestDivisibleSubsets subsets = new LC368LargestDivisibleSubsets();
       List<Integer> lst = subsets.largestDivisibleSubset(nums);
        System.out.println(lst);
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] div = new int[nums.length];
        Arrays.fill(div,1);
        int[] prev = new int[nums.length];
        Arrays.fill(prev,-1);

        int max_idx = 0;

        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && div[i]<div[j]+1){
                    prev[i]=j;
                    div[i]=div[j]+1;
                }
            }
            if(div[i]>max_idx){
                max_idx=i;
            }
        }
        List<Integer> res = new ArrayList<>();
        int k = max_idx;
        while(k>=0){
            res.add(nums[k]);
            k=prev[k];
        }
        return res;
    }
}
