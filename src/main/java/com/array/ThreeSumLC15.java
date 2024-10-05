package com.array;

import java.util.*;

public class ThreeSumLC15 {


    public static void main(String[] args) {
       int arr[] = {-1,0,1,2,-1,-4};
       ThreeSumLC15 lc15 = new ThreeSumLC15();
       List<List<Integer>> result = lc15.threeSum(arr);
       System.out.println(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
      Map<Integer, List<Integer>> map = new HashMap<>();
      for(int i=0;i<nums.length;i++){
          for(int j=1;j<nums.length;j++){
              if(i!=j) {
                  List<Integer> lst  = new ArrayList<>();
                  lst.add(i);
                  lst.add(j);
                  map.put(nums[i] + nums[j], lst);
              }
          }
      }
      List<List<Integer>> resultList = new ArrayList<>();
      List<List<Integer>> processedList = new ArrayList<>();

      for(int i=0;i<nums.length;i++){
          if(map.containsKey((-1*nums[i]))){
              List<Integer> lst = map.get(-nums[i]);
              if(!lst.contains(i)){
                  lst.add(i);
                  List<Integer> output = new ArrayList<>();
                  for(int val: lst){
                      output.add(nums[val]);
                  }
                  resultList.add(output);
              }
          }
      }
      return resultList;
    }
}
