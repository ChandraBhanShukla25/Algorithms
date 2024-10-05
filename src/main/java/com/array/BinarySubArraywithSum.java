package com.array;

import java.util.HashMap;
import java.util.Map;

public class BinarySubArraywithSum {

    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int count= 0;
      for(int i=0;i<nums.length;i++){
          sum += nums[i];
          if(sum==goal){
              count++;
          }
          if(map.containsKey(sum-goal)){
              count+= map.get(sum-goal);
          }
          map.put(sum, map.getOrDefault(sum,0)+1);
      }
      return count;
    }

    public static void main(String[] args) {
       int [] nums = {1,0,1,0,1};
       int goal = 2;

        int [] num1 = {0,0,0,0,0,0,0,0,0,0,0,0,0};
        int goal2 = 0;

       BinarySubArraywithSum subArraywithSum = new BinarySubArraywithSum();
       int x = subArraywithSum.numSubarraysWithSum(nums,goal);
        int y = subArraywithSum.numSubarraysWithSum(num1,goal2);
        System.out.println(x);
        System.out.println(y);
    }
}
