package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC46Permutations {

    public static void main(String[] args) {
      int nums[] = {1,2,3};
      LC46Permutations lc46Permutations = new LC46Permutations();
      List<List<Integer>> resultList = new ArrayList<>();
      lc46Permutations.permute(nums, resultList, 0);
      System.out.println(resultList);
    }

    public void permute(int[] nums, List<List<Integer>> resultList, int size) {
       if(size==nums.length){
           List<Integer> l = new ArrayList<>();
           for(int x:nums){
               l.add(x);
           }
           resultList.add(l);
       }else{
           for(int i=size; i<nums.length;i++){
               swap(i, size, nums);
               permute(nums, resultList, size+1);
               swap(i, size, nums);
           }
       }
    }

    public void swap(int i, int j, int[] nums){
        int x = nums[i];
        nums[i] = nums[j];
        nums[j] = x;
    }
}
