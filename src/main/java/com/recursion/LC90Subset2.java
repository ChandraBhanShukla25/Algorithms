package com.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC90Subset2 {

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        LC90Subset2 subset2 = new LC90Subset2();
        List<List<Integer>> lst = subset2.subsetsWithDup(nums);
        System.out.println(lst);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
      int idx = 0;
      List<List<Integer>> lst = new ArrayList<>();
      List<Integer> result = new ArrayList<>();
      getSubsetsWithDup(nums, idx, lst, result);
      return lst;
    }

    private void getSubsetsWithDup(int[] nums, int idx, List<List<Integer>> lst, List<Integer> result) {
        if(idx>=nums.length){
            List<Integer> res = new ArrayList<>(result);
            Collections.sort(res);
            if(!lst.contains(res))
              lst.add(new ArrayList<>(res));
            return;
        }
        result.add(nums[idx]);
        getSubsetsWithDup(nums, idx+1, lst, result);
        result.remove(result.size()-1);
        getSubsetsWithDup(nums, idx+1, lst, result);
    }
}
