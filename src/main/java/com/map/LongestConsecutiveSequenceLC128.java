package com.map;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequenceLC128 {
    public int longestConsecutive(int[] nums) {
      int smallest = Integer.MAX_VALUE;
      Set<Integer> integerSet = new HashSet<>();
      for(int i : nums){
          if(i < smallest){
              smallest = i;
          }
          integerSet.add(i);
      }

      int longest = 1;
      for(int i=0;i<nums.length;i++){
       if(!integerSet.contains(nums[i]-1)){
          int count = 1;
          int x = nums[i];
          while(integerSet.contains(x+1)){
              count++;
              x=x+1;
          }
           longest = Integer.max(longest,count);
       }
      }
      return  longest;
    }

    public static void main(String[] args) {
        int[] arr = {100,4,200,1,3,2};
        LongestConsecutiveSequenceLC128 consecutiveSequenceLC128 = new LongestConsecutiveSequenceLC128();
        int max = consecutiveSequenceLC128.longestConsecutive(arr);
        System.out.println(max);
    }
}
