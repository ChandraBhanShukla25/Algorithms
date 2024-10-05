package com.array;

import java.util.HashMap;
import java.util.Map;

public class LC2958LongestSubArrayWithKFrequency {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3,1,2};
        int k = 2;

        LC2958LongestSubArrayWithKFrequency frequency = new LC2958LongestSubArrayWithKFrequency();
        int x = frequency.maxSubarrayLength(nums,k);
        System.out.println(x);
    }

    public int maxSubarrayLength(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();
        int maxLength=0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            map.merge(nums[i], 1, Integer::sum );
            while(map.get(nums[i])>k){
                map.merge(nums[i],-1, Integer::sum);
                j++;
            }

            maxLength = Integer.max(maxLength,i-j+1);
        }
       return maxLength;
    }
}
