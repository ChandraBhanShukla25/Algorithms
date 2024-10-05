package com.slidingwindow;

import java.util.Arrays;
import java.util.Map;

public class LC2962AtleasetKTimes {


    public static void main(String[] args) {
        int[] nums = {1,3,2,3,3};
        int k = 2;
        LC2962AtleasetKTimes atleasetKTimes = new LC2962AtleasetKTimes();
        long x = atleasetKTimes.countSubarrays(nums,k);
        System.out.println(x);
    }

    public long countSubarrays(int[] nums, int k) {

        int i = 0;
        int j = 0;

        int max = Arrays.stream(nums).max().getAsInt();
        int count = 0;
        int seqCount = 0;
        System.out.println(max);
        for(i=0;i<nums.length;i++){
            if(max==nums[i]){
                count++;
            }
            if(count==k){
                seqCount++;
                j++;
            }
            if(nums[j]==k){
                count--;
            }

        }
        return seqCount;
    }
}
