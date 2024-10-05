package com.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC47Permutations {

    public static void main(String[] args) {
       int[] nums = {1,1,2};
       LC47Permutations lc = new LC47Permutations();
       lc.permuteUnique(nums);
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> resultList = new HashSet<>();
        permutations(nums, 0, resultList);
        return new ArrayList<>(resultList);
    }

    private void permutations(int[] nums, int size, Set<List<Integer>> resultList){
        if(nums.length==size){
            List<Integer> lst = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                lst.add(nums[i]);
            }
            resultList.add(lst);
        }else{
            for(int i=size;i<nums.length;i++){
                swap(nums, i, size);
                permutations(nums, size+1, resultList);
                swap(nums, i, size);
            }
        }
    }

    private void swap(int[] nums, int i, int size){
        int x = nums[i];
        nums[i] = nums[size];
        nums[size] =  x;
    }
}
