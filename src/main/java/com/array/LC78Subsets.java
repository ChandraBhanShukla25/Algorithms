package com.array;

import java.util.ArrayList;
import java.util.List;

public class LC78Subsets {

    List<List<Integer>> subsets = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        LC78Subsets subsets = new LC78Subsets();
        subsets.subsets(nums);
    }

    public List<List<Integer>> subsets(int[] nums) {
        for(int i=0;i<=nums.length;i++) {
            getSubsets(new ArrayList<>(), nums, i);
        }
        System.out.println(subsets);
        return subsets;
    }

    public void getSubsets(List<Integer> result,int[] nums, int index){
        if(index==nums.length){
            subsets.add(new ArrayList<>(result));
            return;
        }

        for(int i=index;i<nums.length;i++){
            result.add(nums[index]);
            getSubsets(result,nums,i+1);
            result.remove(result.size()-1);
        }
    }
}
