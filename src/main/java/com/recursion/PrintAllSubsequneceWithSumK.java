package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequneceWithSumK {

    public static void main(String[] args) {
        int[] nums = {3,5,6,7,2};
        int target = 9;
        List<List<Integer>> lst = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        PrintAllSubsequneceWithSumK lc = new PrintAllSubsequneceWithSumK();
        lc.getAllSubsequence(nums,target, 0, 0, result, lst);
        System.out.println(lst);
    }

    public void getAllSubsequence(int[] nums, int target, int idx, int sum, List<Integer> result,  List<List<Integer>> lst ){
        if(idx>=nums.length){
            if(sum==target){
                lst.add(new ArrayList<>(result));
            }
            return;
        }
        sum+= nums[idx];
        result.add(nums[idx]);
        getAllSubsequence(nums, target, idx+1,sum, result, lst);
        sum-=nums[idx];
        result.remove(result.size()-1);
        getAllSubsequence(nums, target, idx+1,sum, result, lst);
    }
}
