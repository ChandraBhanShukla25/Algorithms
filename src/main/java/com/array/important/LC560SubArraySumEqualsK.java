package com.array.important;

import java.util.HashMap;
import java.util.Map;

public class LC560SubArraySumEqualsK {

    public static void main(String[] args) {
       int arr[] = {-1,-1,1};
       int k=0;
       LC560SubArraySumEqualsK subArraySumEqualsK = new LC560SubArraySumEqualsK();
       System.out.println(subArraySumEqualsK.subarraySum(arr, k));
    }

    public int subarraySum(int[] nums, int k) {
       Map<Integer,Integer> map = new HashMap<>();
       int count = 0;

       int prefixSum = 0;
       map.put(0,1);
       for(int i=0;i<nums.length;i++){
           prefixSum+=nums[i];
           count+=map.getOrDefault(prefixSum-k, 0);
           map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
       }

       return count;
    }

}
