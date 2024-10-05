package com.array;

import java.util.*;

public class TwoSum {


    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(nums,target);
        Arrays.stream(result).forEach(System.out::println);

    }
    public int[] twoSum(int[] nums, int target) {
     Map<Integer, Integer> map = new HashMap<>();
      for(int i=0;i<nums.length;i++){
            if (map.containsKey(target - nums[i]) && nums[i]*2!=target) {
                int[] arr = new int[2];
                arr[0] = i;
                arr[1] = map.get(target-nums[i]);
                return arr;
            } else {
                map.put(nums[i], i);
            }
        }
     return new int[0];
    }
}
