package com.binarysearch;

import java.util.Arrays;

public class LC410 {

    public static void main(String[] args) {
       int[] nums = {10, 20, 30, 40};
       int k = 2;
       LC410 lc410 = new LC410();
       int split = lc410.splitArray(nums, k);
        System.out.println(split);
    }

    public int splitArray(int[] nums, int k) {
        if(nums.length<k){
            return 0;
        }
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();


        while(low<=high){
            int  mid = (low+high)/2;
            int split = calculate(nums, mid);
            if(split>k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }

    private int calculate(int[] nums, int partitionValue) {
        int partitionCount = 1;
        int partitionSum = 0;
        for(int i= 0; i<nums.length;i++){
            if(partitionSum+nums[i]<=partitionValue){
                partitionSum+=nums[i];
            }else{
                partitionSum= nums[i];
                partitionCount++;
            }
        }
        return partitionCount;
    }
}
